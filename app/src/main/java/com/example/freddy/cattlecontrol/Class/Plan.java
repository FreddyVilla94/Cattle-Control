package com.example.freddy.cattlecontrol.Class;

import java.util.ArrayList;

/**
 * Created by Freddy on 7/4/2018.
 */

public class Plan {

    private int id;
    private String name;
    private String description;
    private ArrayList<Animal> idAnimalList;

    public Plan() {
        idAnimalList = new ArrayList<>();
    }

    public Plan(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        idAnimalList = new ArrayList<>();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Animal> getIdAnimalList() {
        return idAnimalList;
    }

    public void setIdAnimalList(ArrayList<Animal> idAnimalList) {
        this.idAnimalList = idAnimalList;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
