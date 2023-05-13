package com.javarush.cryptanalyzer.maul.services.cipher;

import com.javarush.cryptanalyzer.maul.constants.CryptoAlphabet;



public class CaesarCipher {

    public String cipher(String text, Key key, boolean isEncrypt)  {
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i <text.length(); i++){
            char element = text.charAt(i);
            if(CryptoAlphabet.ALPHABET.indexOf(element)>=0){
                int index = CryptoAlphabet.ALPHABET.indexOf(element);
                ciphertext.append(shiftedChar(key, index, isEncrypt));
            }
            else {
                ciphertext.append(element);
            }
        }
        return ciphertext.toString();
    }
    private char shiftedChar (Key key, int index, boolean isEncrypt)  {
        int alphabetLength = CryptoAlphabet.ALPHABET.length();
        if(isEncrypt){
           return  CryptoAlphabet.ALPHABET.charAt((index + key.getKey()) % alphabetLength);
        }else {
            return CryptoAlphabet.ALPHABET.charAt((index - key.getKey() + alphabetLength) % alphabetLength);
        }
    }
}
