package com.javarush.cryptanalyzer.maul.repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static com.javarush.cryptanalyzer.maul.constants.DefaultTextPath.*;

public class StartText {
    private final String startText;
    private final boolean isEncoded;

    public StartText(String startText, boolean isEncoded) {
        this.startText = startText;
        this.isEncoded = isEncoded;
    }

    private boolean isStartTextDefault() {
        return this.startText.isEmpty();
    }

 public String getStartText() {
        if(this.isEncoded){
            if(isStartTextDefault()){
              return readTextFromFile(DEFAULT_TEXT_PATH_INPUT);
            }
            else {
                return this.startText;
            }
        }else {
            if (isStartTextDefault()){
              return readTextFromFile(DEFAULT_TEXT_PATH_ENCODED);
            }
            else {
                return this.startText;
            }
        }
    }

    private String readTextFromFile(Path path){
        try {
            return Files.readString(path, StandardCharsets.UTF_8);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return this.startText;
    }
}
