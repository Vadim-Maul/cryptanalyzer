package com.javarush.cryptanalyzer.maul.view;


import com.javarush.cryptanalyzer.maul.entity.Result;

public interface View {
    String [] getParameters();

     void printResult(Result result);
}
