package com.galaxy;

import com.galaxy.Representations.People;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


public class UrlManager {

    public String getInfoByPage(int page, String type, boolean another) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("https://swapi.co/api/").append(type).append("/?page=").append(page).append("&format=json");
        String sURL = builder.toString();
        if (page <= 1) {
            builder.setLength(0);
            builder.append("https://swapi.co/api/").append(type).append("/?format=json");
            sURL = builder.toString();
        }
        if (another) {
            builder = new StringBuilder();
            sURL = builder.append(type).append("?format=json").toString();
        }
        URL test = new URL(sURL);
        URLConnection uc = test.openConnection();
        uc.addRequestProperty("User-Agent", "Mozilla/4.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
        String inputLine;
        StringBuilder sb = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            sb.append(inputLine);
        }
        in.close();
        return sb.toString();
    }

    public ArrayList<People> convertJsonToPeople(String jsonString) throws IOException {

        Gson gson = new Gson();
        String[] pe = personMoodification(jsonString);
        int i = 0;
        ArrayList<People> array = new ArrayList<>();
        while (i < pe.length) {
            People person = gson.fromJson(pe[i], People.class);
            person.setHomeworld(getHomeworldName(person.getHomeworld()));
            array.add(person);
            i++;
        }
        return array;

    }

    private String[] personMoodification(String person) {

        String s = person.substring(person.indexOf("name") - 2, person.length() - 3);
        String[] splited = s.split("},");
        int i = 0;
        while (i < splited.length) {
            splited[i] = splited[i].concat("}");
            i++;
        }
        return splited;
    }

    private String getHomeworldName(String url) throws IOException {
        StringBuilder a = new StringBuilder(getInfoByPage(2, url, true));
//        String a = getInfoByPage(2, url, true);
        return a.substring(a.indexOf("name") + 7, a.indexOf("\",\"")).toString();

    }


}
