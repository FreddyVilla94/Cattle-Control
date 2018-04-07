package com.example.freddy.cattlecontrol.Clases;

import java.util.ArrayList;

/**
 * Created by Freddy on 7/4/2018.
 */

public class Farm {

    private int id;
    private String name;
    private Extension extension;
    private ArrayList<Animal> animalList;
    private ArrayList<Plan> planList;
    private ArrayList<Out> outList;

    public Farm() {
        animalList = new ArrayList<>();
        planList = new ArrayList<>();
        outList = new ArrayList<>();
    }

    public Farm(int id, String name, Extension extension) {
        this.id = id;
        this.name = name;
        this.extension = extension;
        animalList = new ArrayList<>();
        planList = new ArrayList<>();
        outList = new ArrayList<>();
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

    public Extension getExtension() {
        return extension;
    }

    public void setExtension(Extension extension) {
        this.extension = extension;
    }

    public ArrayList<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(ArrayList<Animal> animalList) {
        this.animalList = animalList;
    }

    public ArrayList<Plan> getPlanList() {
        return planList;
    }

    public void setPlanList(ArrayList<Plan> planList) {
        this.planList = planList;
    }

    public ArrayList<Out> getOutList() {
        return outList;
    }

    public void setOutList(ArrayList<Out> outList) {
        this.outList = outList;
    }

    @Override
    public String toString() {
        return "Farm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", extension=" + extension +
                '}';
    }
}
