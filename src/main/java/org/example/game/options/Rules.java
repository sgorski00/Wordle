package org.example.game.options;

import org.example.Input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Rules {
    public static void printRules(){
        readRules();
        Input.pressEnterToContinue();
        System.out.println();
    }

    private static void readRules() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("GameRules.txt"));

            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
