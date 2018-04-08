package com.example.freddy.cattlecontrol.Class;

import java.util.ArrayList;

/**
 * Created by Freddy on 7/4/2018.
 */

public class Animal {

    private String id;
    private String breed;
    private boolean gender;
    private String dateOfAdmission;
    private boolean state;
    private ArrayList<WeightHistory> weightHistoryList;

    public Animal() {
        weightHistoryList = new ArrayList<>();
    }

    public Animal(String id, String breed, boolean gender, String dateOfAdmission, boolean state) {
        this.id = id;
        this.breed = breed;
        this.gender = gender;
        this.dateOfAdmission = dateOfAdmission;
        this.state = state;
        weightHistoryList = new ArrayList<>();
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

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(String dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public ArrayList<WeightHistory> getWeightHistoryList() {
        return weightHistoryList;
    }

    public void setWeightHistoryList(ArrayList<WeightHistory> weightHistoryList) {
        this.weightHistoryList = weightHistoryList;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id='" + id + '\'' +
                ", breed='" + breed + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfAdmission='" + dateOfAdmission + '\'' +
                ", state=" + state +
                '}';
    }
}
