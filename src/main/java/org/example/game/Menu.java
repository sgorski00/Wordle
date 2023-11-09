package org.example.game;

import org.example.Input;
import org.example.game.options.Exit;
import org.example.game.options.OptionsMenu;
import org.example.game.options.Rules;
import org.example.game.play.Play;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private final Map<Integer, String> mainMenuList = new HashMap<>();
    private final OptionsMenu options = new OptionsMenu();

    {
        mainMenuList.put(1, "Play");
        mainMenuList.put(2, "Options");
        mainMenuList.put(3, "Game rules");
        mainMenuList.put(9, "Exit");
    }

    public void menu() {
        int choice = 0;
        do {
            do {
                System.out.println("Welcome in the Wordle!");
                System.out.println("Enter the key:");
                printMainMenuList();
                try {
                    choice = Integer.parseInt(Input.getText());
                } catch (NumberFormatException e) {
                    System.err.println("Wrong input");
                }
                switch (choice) {
                    case 1 -> Play.game();
                    case 2 -> options.menu();
                    case 3 -> Rules.printRules();
                    case 9 -> Exit.exit();
                }
            } while (mainMenuList.containsKey(choice));
        } while (choice != 9);

    }

    private void printMainMenuList() {
        for (Map.Entry<Integer, String> entry : mainMenuList.entrySet()) {
            System.out.printf("%d. %s\n", entry.getKey(), entry.getValue());
        }
    }
}
