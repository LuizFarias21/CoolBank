package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write \"Hello\":");
        String message = scanner.nextLine();
        printMessage(message);
    }

    public static String printMessage(String message) {
        return message;
    }
}