
package com.example.freddy.cattlecontrol.Class;


public class WeightHistory {

    private Integer id;
    private String date;
    private Integer weight;

    /**
     * No args constructor for use in serialization
     * 
     */
    public WeightHistory() {
    }

    /**
     * 
     * @param id
     * @param weight
     * @param date
     */
    public WeightHistory(Integer id, String date, Integer weight) {
        super();
        this.id = id;
        this.date = date;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "WeightHistory{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", weight=" + weight +
                '}';
    }
}
