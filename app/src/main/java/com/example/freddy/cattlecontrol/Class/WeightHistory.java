package com.example.freddy.cattlecontrol.Class;

/**
 * Created by Freddy on 7/4/2018.
 */

public class WeightHistory {

    private int id;
    private String date;
    private int weight;

    public WeightHistory() {
    }

    public WeightHistory(int id, String date, int weight) {
        this.id = id;
        this.date = date;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "WeightHistory{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
