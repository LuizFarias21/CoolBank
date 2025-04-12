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

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    private String toDollars(double d) {
        return String.format("$%,.2f", abs(d));
    }
}
