package org.example.game.options;


import org.example.Input;
import org.example.entity.Word;
import org.example.repository.WordRepositoryImpl;
import org.example.util.HibernateUtil;
import org.example.words.IsWordValid;
import org.example.words.website.WordExtractor;

public class Options {
    private static final WordRepositoryImpl repo = new WordRepositoryImpl(HibernateUtil.getSessionFactory());
    public static void addWordToDB(){
        String word = "0";
        do {
            System.out.println("Enter the word: (0 ends the adding)");
            word = Input.getText();
            if (repo.isWordInDB(word)) {
                System.out.println("Word already exists in database");
            } else if (!IsWordValid.isValid(word)) {
                if(!word.equals("0")){
                    System.out.println("Use only 5 letters!");
                }
            } else {
                repo.saveWord(new Word(word));
                System.out.printf("The word: %s, saved!\n", word);
            }
        }while(!word.equals("0"));
    }

    public static void resetDB(){
        System.out.println("Do you want to reset the Database? (y/n)");
        char choice = Input.getText().charAt(0);
        boolean isEnded = false;
        do {
            if (choice == 'y') {
                WordExtractor wordExtractor = new WordExtractor();
                repo.deleteAll();
                wordExtractor.addWordsFromSetToDB();
                System.out.println("Reset done");
                Input.pressEnterToContinue();
                isEnded = true;
            } else if (choice == 'n') {
                Input.pressEnterToContinue();
                isEnded = true;
            } else {
                System.out.println("Press 'y' or 'n'");
                try {
                    choice = Input.getText().charAt(0);
                } catch(StringIndexOutOfBoundsException ignored) {}
            }
        }while(!isEnded);

    }
}
