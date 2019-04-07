package com.galaxy.Representations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "people")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class People {

    private static int a = 0;
    @Id
    private int id = 0;

        @Column(name = "name")
    @JsonProperty("name")
    private String name;
        @Column(name = "homeworld")
    @JsonProperty("homeworld")
    private String homeworld;

    public People() {
        a++;
        id = a;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public People(int id, String name, String homeworld) {
        this.id = id;
        this.name = name;
        this.homeworld = homeworld;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
