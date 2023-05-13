package com.javarush.cryptanalyzer.maul.services.cipher;


import com.javarush.cryptanalyzer.maul.entity.Result;
import com.javarush.cryptanalyzer.maul.exception.AppException;
import com.javarush.cryptanalyzer.maul.repository.ResultCode;
import com.javarush.cryptanalyzer.maul.repository.ResultText;
import com.javarush.cryptanalyzer.maul.repository.StartText;
import com.javarush.cryptanalyzer.maul.services.Function;



public class Decode implements Function {

    @Override
    public Result execute(String[] parameters) {
        try {
            String startText = new StartText(parameters[1]).toString();
            StringBuilder plaintext = new StringBuilder();
            Key key = new Key(parameters[2]);
            CaesarCipher cipher = new CaesarCipher();
            plaintext.append(cipher.cipher(startText, key, false));
            return new Result(ResultCode.OK, new ResultText(plaintext.toString()), key);
        } catch (Exception e) {
            return new Result(ResultCode.ERROR, new AppException("Decode finished with exception: ", e));
        }

    }
}