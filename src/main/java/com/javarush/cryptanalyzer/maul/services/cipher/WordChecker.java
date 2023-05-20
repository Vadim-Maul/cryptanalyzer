package com.javarush.cryptanalyzer.maul.services.cipher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WordChecker {
    private static final String PATTERN = "[А-ЯЁ]\s?[а-яё]{5},?\s[а-яё]{2,8},?\s[а-яё]{2,8},?\s[а-яё]{2,8},?\s.*[\.!\?]";


    public static boolean isPlaintext(String text) {
        Pattern regexOne = Pattern.compile(PATTERN,Pattern.MULTILINE | Pattern.DOTALL);
        Matcher matcher = regexOne.matcher(text);
        return matcher.find();
    }
}
