
package com.example.freddy.cattlecontrol.Class;

import java.util.ArrayList;

public class Farm {

    private String id;
    private String name;
    private Extension extension;
    private ArrayList<Animal> animals = null;
    private ArrayList<Plan> plans = null;
    private ArrayList<Out> out = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Farm() {
        animals = new ArrayList<>();
        plans = new ArrayList<>();
        out = new ArrayList<>();
    }

    /**
     * 
     * @param extension
     * @param id
     * @param plans
     * @param animals
     * @param name
     * @param out
     */
    public Farm(String id, String name, Extension extension) {
        super();
        this.id = id;
        this.name = name;
        this.extension = extension;
        animals = new ArrayList<>();
        plans = new ArrayList<>();
        out = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public ArrayList<Plan> getPlans() {
        return plans;
    }

    public void setPlans(ArrayList<Plan> plans) {
        this.plans = plans;
    }

    public ArrayList<Out> getOut() {
        return out;
    }

    public void setOut(ArrayList<Out> out) {
        this.out = out;
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
