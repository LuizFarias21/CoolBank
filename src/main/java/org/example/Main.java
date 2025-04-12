package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("Welcome! What is your name?");
        String name = scanner.nextLine();
        Customer customer = new Customer(name);
        System.out.println("\nHello, " + customer.getName() + ".\n");

        do {
            System.out.println("============= COOL BANK =============");
            System.out.println("0 - Exit");
            System.out.println("1 - See number of accounts");
            System.out.println("2 - Open an account");

            System.out.print("Enter your option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Total number of accounts: " + customer.getNumberOfAccounts());
                    break;
                case 2:
                    System.out.println("\nWhat type of account do you want?");
                    System.out.println("0 - Checking account");
                    System.out.println("1 - Saving account");
                    System.out.println("2 - Maxi-saving account");
                    System.out.print("Enter your option: ");
                    int accountType = scanner.nextInt();
                    switch (accountType) {
                        case 0:
                            customer.openAccount(new Account(0));
                            break;
                        case 1:
                            customer.openAccount(new Account(1));
                            break;
                        case 2:
                            customer.openAccount(new Account(2));
                            break;
                    }
                    System.out.println(customer.getAccounts());
            }


        } while (option != 0);


    }
}


