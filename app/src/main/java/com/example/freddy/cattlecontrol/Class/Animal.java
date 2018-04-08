
package com.example.freddy.cattlecontrol.Class;

import java.util.ArrayList;

public class Animal {

    private String id;
    private String breed;
    private Boolean gender;
    private String dateOfAdmission;
    private Boolean state;
    private ArrayList<WeightHistory> weightHistory = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Animal() {
        weightHistory = new ArrayList<>();
    }

    /**
     * 
     * @param weightHistory
     * @param id
     * @param breed
     * @param state
     * @param gender
     * @param dateOfAdmission
     */
    public Animal(String id, String breed, Boolean gender, String dateOfAdmission, Boolean state) {
        super();
        this.id = id;
        this.breed = breed;
        this.gender = gender;
        this.dateOfAdmission = dateOfAdmission;
        this.state = state;
        weightHistory = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(String dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public ArrayList<WeightHistory> getWeightHistory() {
        return weightHistory;
    }

    public void setWeightHistory(ArrayList<WeightHistory> weightHistory) {
        this.weightHistory = weightHistory;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id='" + id + '\'' +
                ", breed='" + breed + '\'' +
                ", gender=" + gender +
                ", dateOfAdmission='" + dateOfAdmission + '\'' +
                ", state=" + state +
                '}';
    }
}
