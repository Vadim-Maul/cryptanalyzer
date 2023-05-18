package com.javarush.cryptanalyzer.maul.view;

import com.javarush.cryptanalyzer.maul.entity.Result;
import java.util.Scanner;

import static com.javarush.cryptanalyzer.maul.constants.ApplicationCompletionConstants.*;
import static com.javarush.cryptanalyzer.maul.constants.UserQuestions.*;

public class ConsoleView implements View {


    public String[] askQuestions() {
        String[] answers = new String[3];
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(START);
            System.out.println(MODE);
            String mode = scanner.nextLine();
            answers[0] = mode;
            switch (answers[0]) {
                case "1" -> onFirstModeAnswers(scanner, answers);
                case "2" -> onSecondMode(scanner, answers);
                default -> onThirdMode(scanner, answers);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }
        return answers;
    }

    private void onFirstModeAnswers(Scanner scanner, String[] answers) {
        String[] firstModeQuestions = {DEFAULT_TEXT, KEY};
        for (int i = 0; i < firstModeQuestions.length; i++) {
            System.out.println(firstModeQuestions[i] + " ");
            answers[i + 1] = scanner.nextLine();
        }
    }

    private void onSecondMode(Scanner scanner, String[] answers) {
        String[] secondModeQuestions = {DEFAULT_TEXT, KEY};
        for (int i = 0; i < secondModeQuestions.length; i++) {
            System.out.println(secondModeQuestions[i] + " ");
            answers[i + 1] = scanner.nextLine();
        }
    }

    private void onThirdMode(Scanner scanner, String[] answers) {
        System.out.println(DEFAULT_TEXT);
        answers[1] = scanner.nextLine();
    }

    public String[] getParameters() {
        return askQuestions();
    }

    public void printResult(Result result) {
        switch (result.getResultCode()) {
            case OK ->
                    System.out.println(SUCCESS + "\n" + "Your key: " + result.getKey());
            case ERROR -> System.out.println(EXCEPTION + result.getAppException().getMessage());
        }
    }

}
