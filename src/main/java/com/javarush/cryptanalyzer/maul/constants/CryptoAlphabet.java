package com.javarush.cryptanalyzer.maul.constants;

public class CryptoAlphabet {
    private static final String LETTERS_UPPERCASE = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩИЙЦУКЕНГШЩЪЫЬЭЮЯ";
    private static final String LETTERS_LOWERCASE = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = ".,\":-!? ";
    public static final String ALPHABET = LETTERS_UPPERCASE + LETTERS_LOWERCASE + NUMBERS + SYMBOLS;
}
