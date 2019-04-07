package com.galaxy.Logic;

import com.galaxy.Representations.People;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestAPI {


    private InfoService info = new InfoService();

    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    @RequestMapping(name = "/preparations", method = RequestMethod.POST)
    public String preparations() {

        return "db: "+ info.takeInfoToDB();
    }


    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @RequestMapping(name = "/people", method = RequestMethod.GET)
    public List<People> getAll() {
        if (info.getAll().isEmpty())
            return null;

        return info.getAll();
    }

    @RequestMapping(value = "/game/{name}", method = RequestMethod.PUT)
    @ResponseBody// коли є - method = RequestMethod.GET - видає помилку
    public String game(@PathVariable("name") String name) {
        People p = info.findPersonByName(name);
        if (p == null) {
            return "None person like this in db";
        } else {
            People e = info.findPersonByHome(p.getHomeworld());
            while(true) {
                if (e.getName().equals(name))
                    e = info.findPersonByHome(p.getHomeworld());
                else break;
            }
            People i = info.findRandom(e.getHomeworld());
            return p.getName()+" and "+e.getName()+" with equal planet "+e.getHomeworld()+", but "+i.getName()+" from "+i.getHomeworld();
        }
    }



}
