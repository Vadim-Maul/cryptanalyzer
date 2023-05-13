package com.javarush.cryptanalyzer.maul.services;

import com.javarush.cryptanalyzer.maul.entity.Result;

public interface Function {
    Result execute(String[]parameters);
}
