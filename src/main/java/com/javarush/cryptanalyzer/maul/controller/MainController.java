package com.javarush.cryptanalyzer.maul.controller;

import com.javarush.cryptanalyzer.maul.Main;
import com.javarush.cryptanalyzer.maul.view.View;


public class MainController {
    private View view;

    public MainController(View view){
        this.view = view;
    }

    public View getView() {
        return view;
    }
}
