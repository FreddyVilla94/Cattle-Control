
package com.example.freddy.cattlecontrol.Class;

import java.util.ArrayList;

public class Plan {

    private Integer id;
    private String name;
    private String description;
    private ArrayList<Animal> animals = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Plan() {
        animals = new ArrayList<>();
    }

    /**
     * 
     * @param id
     * @param animals
     * @param description
     * @param name
     */
    public Plan(Integer id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        animals = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
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
