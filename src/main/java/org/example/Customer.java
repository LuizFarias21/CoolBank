package org.example;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class Customer {

    private final String name;
    private final ArrayList<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<Account>();
    }

    public String getName() {
        return name;
    }

    public void openAccount(Account account) {
        accounts.add(account);
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public String statementForAccount(Account account) {
        String s = "";

        switch (account.getAccountType()) {

            case Account.CHECKING:
                s += "Checking Account\n";
                break;
            case Account.SAVINGS:
                s += "Savings Account\n";
                break;
            case Account.MAXI_SAVINGS:
                s += "Maxi Savings Account\n";
                break;
        }

        for (Transaction t : account.getTransactions()) {
            s += " " + (t.getAmount() < 0 ? "withdraw" : "deposit") + " " + toDollars(t.getAmount()) + "\n";
        }

        s += "Total " + toDollars(account.sumTransactions());
        return s;
    }

    public String getStatement() {
        String statement = "Statement for " + name + "\n";
        double total = 0;

        for (Account account : accounts) {
            statement += "\n" + statementForAccount(account) + "\n";
            total += account.sumTransactions();
        }

        statement += "\nTotal in all accounts " + toDollars(total);
        return statement;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    private String toDollars(double d) {
        return String.format("$%,.2f", abs(d));
    }
}
