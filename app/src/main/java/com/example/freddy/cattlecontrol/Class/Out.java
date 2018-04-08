package com.example.freddy.cattlecontrol.Class;

/**
 * Created by Freddy on 7/4/2018.
 */

public class Out {

    private int id;
    private String idAnimal;
    private String date;
    private String destiny;

    public Out() {}

    public Out(int id, String idAnimal, String date, String destiny) {
        this.id = id;
        this.idAnimal = idAnimal;
        this.date = date;
        this.destiny = destiny;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(String idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    @Override
    public String toString() {
        return "Out{" +
                "id='" + id + '\'' +
                ", idAnimal='" + idAnimal + '\'' +
                ", date='" + date + '\'' +
                ", destiny='" + destiny + '\'' +
                '}';
    }
}
