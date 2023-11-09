package org.example.game.play;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LettersCheckerTest {

    @Test
    public void assertTrueIfCorrectReplaceOfChars(){
        //given
        String usersWord = "until";
        String drawnWord = "ujpik";
        String newWord;

        //when
        newWord = LettersChecker.checkAndReturnWord(usersWord, drawnWord);

        //then
        Assertions.assertEquals("UntIl", newWord);
    }

    @Test
    public void assertTrueIfCorrectReplaceOfAllChars(){
        //given
        String usersWord = "until";
        String drawnWord = "until";
        String newWord;

        //when
        newWord = LettersChecker.checkAndReturnWord(usersWord, drawnWord);

        //then
        Assertions.assertEquals("UNTIL", newWord);
    }

    @Test
    public void assertFalseIfReplaceAllLetterInsteadOfOne(){
        //given
        String usersWord = "uuuuu";
        String drawnWord = "uxudu";
        String newWord;

        //when
        newWord = LettersChecker.checkAndReturnWord(usersWord, drawnWord);

        //then
        Assertions.assertEquals("UuUuU", newWord);
    }
}