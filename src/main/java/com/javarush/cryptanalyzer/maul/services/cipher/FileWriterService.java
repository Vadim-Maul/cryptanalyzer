package com.javarush.cryptanalyzer.maul.services.cipher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static com.javarush.cryptanalyzer.maul.constants.DefaultTextPath.DEFAULT_TEXT_PATH_ENCODED;
import static com.javarush.cryptanalyzer.maul.constants.DefaultTextPath.DEFAULT_TEXT_PATH_OUTPUT;

public class FileWriterService {
    private FileWriterService() {

    }

    public static void writeToFile(String text, boolean isEncoded) {
        Path fileName = isEncoded ? DEFAULT_TEXT_PATH_ENCODED : DEFAULT_TEXT_PATH_OUTPUT;
        try {
            if (!Files.exists(fileName)) {
                Files.createFile(fileName);
            }
            Files.writeString(fileName, text, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
