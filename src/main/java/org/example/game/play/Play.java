package org.example.game.play;

import org.example.Input;
import org.example.entity.Word;
import org.example.repository.WordRepositoryImpl;
import org.example.util.HibernateUtil;
import org.example.words.IsWordValid;
import org.example.words.website.WordExtractor;

import java.io.IOException;

public class Play {
    public static void game() {
        WordRepositoryImpl repo = new WordRepositoryImpl(HibernateUtil.getSessionFactory());
        String drawnWord = repo.getWordById(Random.getRandomNumber()).word();
        String usersWord;
        boolean isWordOk = false;
        int lives;

        for (lives = 6; lives > 0; lives--) {
            System.out.println("Lives:" + lives);
            Board.printFirstBoard();
            System.out.println("Enter the 5-letter word:");
            do {
                usersWord = Input.getText().toLowerCase();
                if(!IsWordValid.isValid(usersWord)){
                    System.out.println("Use only 5 letters.");
                } else if(!repo.isWordInDB(usersWord)){
                    System.out.println("There is no such a word in Database");
                } else{
                    isWordOk = true;
                }
            }
            while (!isWordOk);
            System.out.println(usersWord);
        }
    }
}
