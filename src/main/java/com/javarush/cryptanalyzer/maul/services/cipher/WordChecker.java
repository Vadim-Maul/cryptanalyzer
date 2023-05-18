package com.javarush.cryptanalyzer.maul.services.cipher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WordChecker {
    private static final String PATTERN = "[А-ЯЁ]\\s?[а-яё]+,?\\s[а-яё]+\\s.*\\.";
    //private static final String PATTERN = "^[А-ЯЁ][а-яё\\s,;:-]*[.?!]$";


    public static boolean isPlaintext(String text) {
        Pattern regexOne = Pattern.compile(PATTERN,Pattern.MULTILINE | Pattern.DOTALL);
        Matcher matcher = regexOne.matcher(text);
        return matcher.find();
    }
}
