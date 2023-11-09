package org.example.game.play;

import org.example.Input;
import org.example.repository.WordRepositoryImpl;
import org.example.util.HibernateUtil;
import org.example.words.IsWordValid;

public class Play {
    private static final WordRepositoryImpl repo = new WordRepositoryImpl(HibernateUtil.getSessionFactory());

    public static void game() {
        Board board = new Board();
        String drawnWord = repo.getWordById(Random.getRandomNumber()).word();
        String usersWord;
        char[][] clonedBoard = board.board();
        int lives = 6;

        for (int i = 0; i < clonedBoard.length; i++) {
            System.out.println("Lives:" + lives);
            board.printBoard();
            System.out.println("Enter the 5-letter word:");
            usersWord = getValidWord();
            usersWord = LettersChecker.checkAndReturnWord(usersWord, drawnWord);
            for(int j = 0; j < clonedBoard[i].length; j++){
                clonedBoard[i][j]=usersWord.charAt(j);
            }
            if(usersWord.equalsIgnoreCase(drawnWord)){
                break;
            }
            lives--;
        }

        board.printBoard();

        if(lives>0){
            System.out.println("You won! Your lives: " + lives);
            System.out.println("The word was: " + drawnWord);
        }else {
            System.out.println("You lost, try again. The word was: " + drawnWord);
        }
        Input.pressEnterToContinue();
        System.out.println();
    }

    private static String getValidWord() {
        String usersWord;
        boolean isWordOk = false;
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
        return usersWord;
    }
}
