package com.javarush.cryptanalyzer.maul;

import com.javarush.cryptanalyzer.maul.app.Application;
import com.javarush.cryptanalyzer.maul.controller.MainController;
import com.javarush.cryptanalyzer.maul.entity.Result;
import com.javarush.cryptanalyzer.maul.view.ConsoleView;
import com.javarush.cryptanalyzer.maul.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleView();
        MainController mainController = new MainController(view);
        Application application = new Application(mainController);
        Result result = application.run();
        application.printResult(result);
    }
}
