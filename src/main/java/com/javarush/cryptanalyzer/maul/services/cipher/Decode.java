package com.javarush.cryptanalyzer.maul.services.cipher;


import com.javarush.cryptanalyzer.maul.entity.Result;
import com.javarush.cryptanalyzer.maul.exception.AppException;
import com.javarush.cryptanalyzer.maul.repository.ResultCode;
import com.javarush.cryptanalyzer.maul.repository.StartText;
import com.javarush.cryptanalyzer.maul.services.Function;



public class Decode implements Function {

    @Override
    public Result execute(String[] parameters) {
        try {
            boolean isEncoded = false;
            String startText = new StartText(parameters[1], isEncoded).getStartText();
            String plaintext;
            Key key = new Key(parameters[2]);
            CaesarCipher cipher = new CaesarCipher();
            plaintext = cipher.cipher(startText, key, false);
            FileWriterService.writeToFile(plaintext, isEncoded);
            return new Result(ResultCode.OK, key);
        } catch (Exception e) {
            return new Result(ResultCode.ERROR, new AppException("Decode finished with exception: ", e));
        }

    }
}