package com.galaxy.Logic;

//import com.galaxy.Hibernate.PeopleDao;

import com.galaxy.Representations.People;
import com.galaxy.UrlManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InfoService {

//    private PeopleDao peopleDao;

    List<People> peopleList = new ArrayList<>();

    boolean takeInfoToDB() {

        UrlManager s = new UrlManager();
        for (int g = 1; g <= 9; g++) {
            try {
                String people = s.getInfoByPage(g, "people", false);
                ArrayList<People> list = s.convertJsonToPeople(people);

                peopleList.addAll(list);
            } catch (IOException e) {
                System.out.println(e);
                return false;
            }
        }
        return true;
    }

    People findPersonByName(String value) {
        for (int i = 0; i < peopleList.size(); i++) {
            if (peopleList.get(i).getName().equals(value)) {
                return peopleList.get(i);
            }
        }
        return null;
    }

    People findPersonByHome(String value) {
        Random r = new Random();
        while (true) {
            People p = peopleList.get(r.nextInt(87));
            if (p.getHomeworld().equals(value)) {
                return p;
            } else
                continue;
        }
    }

    People findRandom(String home) {
        Random r = new Random();
        while (true) {
            People p = peopleList.get(r.nextInt(87));
            if (!p.getHomeworld().equals(home)) {
                return p;
            } else
                continue;
        }

    }
//
//    People findAnother(String planet){
//
//    }

    List<People> getAll() {
        return peopleList;
    }
}
