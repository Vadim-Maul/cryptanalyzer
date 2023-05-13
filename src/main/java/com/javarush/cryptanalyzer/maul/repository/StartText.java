package com.javarush.cryptanalyzer.maul.repository;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static com.javarush.cryptanalyzer.maul.constants.DefaultTextPath.DEFAULT_TEXT_PATH;

public class StartText {
    private final String startText;

    public StartText(String startText) {
        this.startText = startText;
    }

    private boolean isStartTextDefault(){
        return this.startText.isEmpty();
    }


    public String getStartText(){
        if (isStartTextDefault()){
           try {
               return Files.readString(DEFAULT_TEXT_PATH, StandardCharsets.UTF_8);
           }catch (IOException e){
               e.printStackTrace();
           }
        }
            return startText;
    }

    public String toString(){
        return this.startText;
    }
}
