package com.javarush.cryptanalyzer.maul.services;

import com.javarush.cryptanalyzer.maul.entity.Result;

public class NoFunction implements Function{
    @Override
    public Result execute(String[] parameters) {
        return null;
    }
}
