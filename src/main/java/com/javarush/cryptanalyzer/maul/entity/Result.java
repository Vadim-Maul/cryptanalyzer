package com.javarush.cryptanalyzer.maul.entity;


import com.javarush.cryptanalyzer.maul.exception.AppException;
import com.javarush.cryptanalyzer.maul.repository.ResultCode;
import com.javarush.cryptanalyzer.maul.repository.ResultText;

import com.javarush.cryptanalyzer.maul.services.cipher.Key;


public class Result {
    private ResultCode resultCode;
    private AppException appException;
    private Key key;

    private ResultText resultText;
    public Result(ResultCode resultCode){
        this.resultCode = resultCode;
    }

    public Result(ResultCode resultCode, Key key){
        this.resultCode = resultCode;
        this.key = key;
    }

    public Result(ResultCode resultCode, ResultText resultText) {
        this.resultCode = resultCode;
        this.resultText = resultText;
    }

    public Result(ResultCode resultCode, ResultText resultText, Key key){
        this.resultCode = resultCode;
        this.resultText = resultText;
        this.key = key;
    }
    public Result(ResultCode resultCode, AppException appException){
        this.resultCode = resultCode;
        this.appException = appException;
    }

    public ResultCode getResultCode(){
        return resultCode;
    }

    public ResultText getResultText(){return resultText;}

    public Key getKey() {
        return key;
    }


    public AppException getAppException() {
        return appException;
    }
}
