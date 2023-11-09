package org.example.game.play;

public class LettersChecker {
    public static String checkAndReturnWord(String usersWord, String drawnWord){
        char validChar;
        for(int i = 0; i<usersWord.length(); i++){
            if(usersWord.charAt(i) == drawnWord.charAt(i)){
                validChar = Character.toUpperCase(usersWord.charAt(i));
                usersWord = usersWord.substring(0,i) + validChar + usersWord.substring(i+1);
            }
        }
        return usersWord;
    }
}
