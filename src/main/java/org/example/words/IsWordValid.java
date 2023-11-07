package org.example.words;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsWordValid {
    private static final String REGEX = "^[a-zA-Z]{5}$";
    public static boolean isValid(String word) {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(word);
        return m.matches();
    }
}
