package org.example.game.play;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

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

    public static String addLetterToWordIfExistsInAnyPosition(String usersWord, String drawnWord, String lettersInWord){
        StringBuilder letters = new StringBuilder();
        char[] lettersFromDrawWord = drawnWord.toCharArray();

        for(int i = 0; i<usersWord.length(); i++){
            for(char c : lettersFromDrawWord){
                if(usersWord.charAt(i) == c){
                    letters.append(c);
                }
            }
        }

        lettersInWord += letters;
        lettersInWord = removeDuplicate(lettersInWord.toLowerCase().toCharArray());
        return sortWordAlphabetically(lettersInWord.toCharArray()).toUpperCase();
    }

    private static String removeDuplicate(char[] str) {
        Set<Character> charactersSet = new LinkedHashSet<>();
        StringBuilder word = new StringBuilder();
        for(char c : str){
            charactersSet.add(c);
        }
        for(Character c : charactersSet){
            word.append(c);
        }
        return word.toString();
    }

    private static String sortWordAlphabetically(char[] str){
        int size = str.length;
        char temp;
        for(int i = 0; i < size; i++ ) {
            for(int j = i+1; j < size; j++) {
                if(str[i]>str[j]) {
                    temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
        return String.valueOf(str);
    }
}
