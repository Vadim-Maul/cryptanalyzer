package com.javarush.cryptanalyzer.maul.services.cipher;

import com.javarush.cryptanalyzer.maul.constants.CryptoAlphabet;


public class Key {
    private final String key;

    public Key(String key) {
        if (isKeyEmpty(key) || isNotValid(key)) {
            this.key = String.valueOf(generateRandomKey());
        } else {
            this.key = key;
        }
    }

    private boolean isKeyEmpty(String key) {
        return key.isEmpty();
    }

    private boolean isNotValid(String key) {
        int intKey = Integer.parseInt(key);
        return (intKey > CryptoAlphabet.ALPHABET.length()) || (intKey < 0);
    }

    private int generateRandomKey() {
        return rnd(30);
    }

    private int rnd(int max) {
        return (int) (Math.random() * ++max);
    }

    public int getKey() {
        return Integer.parseInt(this.key);
    }

    public String toString() {
        return this.key;
    }


}
