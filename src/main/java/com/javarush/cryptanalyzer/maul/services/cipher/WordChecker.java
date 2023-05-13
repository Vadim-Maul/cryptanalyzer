package com.javarush.cryptanalyzer.maul.services.cipher;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import static com.javarush.cryptanalyzer.maul.constants.API.API_KEY;

public class WordChecker {
    public static boolean isWord (String text){
        try {
            String urlStr = "https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key=" + API_KEY + "&lang=ru-ru&text=" + URLEncoder.encode(text, "UTF-8");
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            StringBuffer response = new StringBuffer();
            int status = con.getResponseCode();
            if (status == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            } else {
                System.out.println("Ошибка выполнения запроса");
            }
            con.disconnect();
            if (response.length() > 50) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
