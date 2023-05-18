package com.javarush.cryptanalyzer.maul.services.cipher;

import com.javarush.cryptanalyzer.maul.constants.CryptoAlphabet;
import com.javarush.cryptanalyzer.maul.entity.Result;
import com.javarush.cryptanalyzer.maul.exception.AppException;
import com.javarush.cryptanalyzer.maul.repository.ResultCode;
import com.javarush.cryptanalyzer.maul.repository.StartText;
import com.javarush.cryptanalyzer.maul.services.Function;


public class BruteForce implements Function {

    @Override
    public Result execute(String[] parameters) {
        boolean isEncoded = false;
        String startText = new StartText(parameters[1], isEncoded).getStartText();
        String plaintext;
        if (findKey(startText) != null) {
            Key key = findKey(startText);
            CaesarCipher caesarCipher = new CaesarCipher();
            plaintext = caesarCipher.cipher(startText, key, false);
            FileWriterService.writeToFile(plaintext, isEncoded);
            return new Result(ResultCode.OK, key);
        }
        return new Result(ResultCode.ERROR, new AppException("Brute Force is impossible, please give other text"));
    }


    private Key findKey(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();
        int ALPHABET_SIZE = CryptoAlphabet.ALPHABET.length();
        for (int shift = 0; shift < ALPHABET_SIZE; shift++) {
            for (int i = 0; i < ciphertext.length(); i++) {
                char c = ciphertext.charAt(i);
                int index = CryptoAlphabet.ALPHABET.indexOf(c);
                if (index != -1) {
                    char shiftedChar = CryptoAlphabet.ALPHABET.charAt((index - shift + ALPHABET_SIZE) % ALPHABET_SIZE);
                    plaintext.append(shiftedChar);
                } else {
                    plaintext.append(c);
                }
            }
            if (WordChecker.isPlaintext(plaintext.toString())) {
                return new Key(String.valueOf(shift));
            }
            plaintext.setLength(0);
        }
        return null;
    }
}