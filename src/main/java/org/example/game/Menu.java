package org.example.game;

import org.example.Input;
import org.example.game.play.Play;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Menu {
    private final Map<Integer, String> mainMenuList = new HashMap<>();

    {
        mainMenuList.put(1, "Play");
        mainMenuList.put(2, "Options");
        mainMenuList.put(3, "Game rules");
        mainMenuList.put(9, "Exit");
    }

    public void menu() {
        int choice = 0;
        do {
            System.out.println("Welcome in the Wordle!");
            System.out.println("Enter the key:");
            printMainMenuList();
            try {
                choice = Integer.parseInt(Input.getText());
            } catch (NumberFormatException e) {
                System.err.println("Wrong input");
            }
            switch (choice){
                case 1 -> Play.game();
//                case 2 -> //options
//                case 3 -> //rules
                case 9 -> Exit.exit();
            }
        }while(!getMainMenuList().containsKey(choice));

    }

    public Map<Integer, String> getMainMenuList() {
        return mainMenuList;
    }

    private void printMainMenuList() {
        for (Map.Entry<Integer, String> entry : getMainMenuList().entrySet()) {
            System.out.printf("%d. %s\n", entry.getKey(), entry.getValue());
        }
    }
}
