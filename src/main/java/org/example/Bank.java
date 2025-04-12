package org.example;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class Bank {
    private final ArrayList<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<Customer>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public String customerSummary() {
        String summary = "Customer Summary";
        for (Customer customer : customers) {
            summary += "\n - " + customer.getName() + " (" + format(customer.getNumberOfAccounts(), "account") + ")";
        }
        return summary;
    }

    public String format(int number, String word) {
        return number + " " + (number == 1 ? word : word + "s");
    }

    public double totalInterestPaid() {
        double total = 0;
        for (Customer customer : customers) total += customer.totalInterestEarned();
        return total;
    }

    public static String toDollars(double value) {
        return String.format("$%,.2f", abs(value));
    }

}
