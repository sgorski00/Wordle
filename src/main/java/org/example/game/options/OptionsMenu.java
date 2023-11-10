package org.example.game.options;

import org.example.Input;

import java.util.HashMap;
import java.util.Map;

public class OptionsMenu {
    private final Map<Integer, String> optionsMenuList = new HashMap<>();

    {
        optionsMenuList.put(1, "Add word to Database");
        optionsMenuList.put(2, "Reset database");
        optionsMenuList.put(9, "Go back");
    }

    public void menu(){
        int choice = 0;
        System.out.println("Options");
        printMainMenuList();
        do {
            System.out.println("Enter the number:");
            try {
                choice = Integer.parseInt(Input.getText());
            } catch (NumberFormatException e) {
                System.err.println("Wrong input\n");
            }
            switch (choice){
                case 1 -> Options.addWordToDB();
                case 2 -> Options.resetDB();
                case 9 -> System.out.println("Going back");
                default -> System.err.println("Enter correct number\n");
            }
        }while(!optionsMenuList.containsKey(choice));
        System.out.println();
    }

    private void printMainMenuList() {
        for (Map.Entry<Integer, String> entry : optionsMenuList.entrySet()) {
            System.out.printf("%d. %s\n", entry.getKey(), entry.getValue());
        }
        System.out.println();
    }
}
