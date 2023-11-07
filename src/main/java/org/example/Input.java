package org.example;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getText() {
        return scanner.nextLine();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
