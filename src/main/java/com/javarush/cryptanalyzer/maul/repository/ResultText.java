package com.javarush.cryptanalyzer.maul.repository;

public class ResultText {
    private final String resultText;

    public ResultText(String resultText) {
        this.resultText = resultText;
    }

    public String toString(){
        return this.resultText;
    }
}
