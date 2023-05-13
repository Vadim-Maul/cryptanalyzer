package com.javarush.cryptanalyzer.maul.services.cipher;

import com.javarush.cryptanalyzer.maul.constants.CryptoAlphabet;
import com.javarush.cryptanalyzer.maul.entity.Result;
import com.javarush.cryptanalyzer.maul.exception.AppException;
import com.javarush.cryptanalyzer.maul.repository.ResultCode;
import com.javarush.cryptanalyzer.maul.repository.ResultText;
import com.javarush.cryptanalyzer.maul.repository.StartText;
import com.javarush.cryptanalyzer.maul.services.Function;


import java.util.HashMap;
import java.util.Map;


public class BruteForce implements Function {

    @Override
    public Result execute(String[] parameters) {
        try {
            String startText = new StartText(parameters[1]).toString();
            String plaintext;
            if (startText.length() < 10) {
                return new Result(ResultCode.ERROR, new AppException("Brute Force is impossible, please write more words"));
            }
            char mostFrequentChar = findMostFrequentChar(startText);
            String[] spacedString = splitBySpace(mostFrequentChar, startText);
            for (int i = 0; i < spacedString.length; i++) {
                Key key = findKey(spacedString[i]);
                if (key.toString() != null) {
                    CaesarCipher caesarCipher = new CaesarCipher();
                    plaintext = caesarCipher.cipher(startText, key, false);
                    return new Result(ResultCode.OK, new ResultText(plaintext), key);
                }
            }
            return new Result(ResultCode.ERROR, new AppException("Brute Force is impossible, please give other text(not found)"));
        } catch (Exception e) {
            return new Result(ResultCode.ERROR, new AppException("Brute Force is impossible, please write more words or give other text"));
        }

    }

    private String[] splitBySpace(char mostFrequentChar, String text) {
        StringBuilder plaintext = new StringBuilder();
        char[] textToCharArray = text.toCharArray();
        for (int i = 0; i < textToCharArray.length; i++) {
            if (textToCharArray[i] == mostFrequentChar) {
                textToCharArray[i] = ' ';
                plaintext.append(textToCharArray[i]);
            } else {
                plaintext.append(textToCharArray[i]);
            }
        }
        return plaintext.toString().split("\\s+");
    }

    public char findMostFrequentChar(String str) {
        Map<Character, Integer> charMap = new HashMap<>();
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (Character.isLetterOrDigit(c)) {
                charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            }
        }
        int maxCount = 0;
        char maxChar = 0;
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxChar = entry.getKey();
            }
        }
        return maxChar;
    }


    private Key findKey(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();
        int ALPHABET_SIZE = CryptoAlphabet.ALPHABET.length();
        for (int shift = 0; shift < ALPHABET_SIZE; shift++) {
            for (int i = 0; i < ciphertext.length(); i++) {
                char ch = ciphertext.charAt(i);
                int index = CryptoAlphabet.ALPHABET.indexOf(ch);
                if (index != -1) {
                    char shiftedChar = CryptoAlphabet.ALPHABET.charAt((index - shift + ALPHABET_SIZE) % ALPHABET_SIZE);
                    plaintext.append(shiftedChar);
                } else {
                    plaintext.append(ch);
                }
            }
            if (WordChecker.isWord(plaintext.toString())) {
                return new Key(shift + "");
            }
            plaintext.setLength(0);
        }
        return null;
    }
}