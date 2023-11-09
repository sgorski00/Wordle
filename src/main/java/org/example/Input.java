package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getText() {
        return scanner.nextLine();
    }

    public static void pressEnterToContinue() {
        System.out.println("Press enter to continue.");
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeScanner() {
        scanner.close();
    }
}
