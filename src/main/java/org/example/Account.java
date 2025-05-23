package org.example;

import java.util.ArrayList;

public class Account {

    public static final int CHECKING = 0;
    public static final int SAVINGS = 1;
    public static final int MAXI_SAVINGS = 2;

    private final int accountType;
    private final ArrayList<Transaction> transactions;

    public Account(int accountType) {
        this.accountType = accountType;
        this.transactions = new ArrayList<Transaction>();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        } else {
            transactions.add(new Transaction(amount));
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        } else {
            transactions.add(new Transaction(-amount));
        }
    }

    public double interestEarned() {
        double amount = sumTransactions();

        switch (accountType) {
            case CHECKING:
                return amount * 0.001;
            case SAVINGS:
                if  (amount <= 1000) return amount * 0.001;
                else return amount * 0.002;
            case MAXI_SAVINGS:
                if (amount <= 1000) return amount * 0.02;
                if (amount > 1000 && amount <= 2000) return amount * 0.05;
                return amount * 0.10;
            default:
                throw new IllegalStateException("Unknown account type: " + accountType);
        }
    }

    public double sumTransactions() {
        double amount = 0;
        for (Transaction t : transactions) amount += t.getAmount();
        return amount;
    }

    public int getAccountType() {
        return accountType;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}
