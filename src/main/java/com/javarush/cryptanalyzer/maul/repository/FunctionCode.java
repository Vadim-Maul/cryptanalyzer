package com.javarush.cryptanalyzer.maul.repository;

import com.javarush.cryptanalyzer.maul.services.cipher.BruteForce;
import com.javarush.cryptanalyzer.maul.services.cipher.Decode;
import com.javarush.cryptanalyzer.maul.services.cipher.Encode;
import com.javarush.cryptanalyzer.maul.services.Function;
import com.javarush.cryptanalyzer.maul.services.NoFunction;

public enum FunctionCode {
    ENCODE(new Encode()), DECODE(new Decode()), BRUTE_FORCE(new BruteForce()), NO_FUNCTION(new NoFunction());
    private Function function;
    FunctionCode(Function function){
        this.function = function;
    }

    public Function getFunction() {
        return function;
    }
}
