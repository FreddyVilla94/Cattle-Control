
package com.example.freddy.cattlecontrol.Class;


public class Out {

    private Integer id;
    private String idAnimal;
    private String date;
    private Boolean destiny;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Out() {
    }

    /**
     * 
     * @param id
     * @param idAnimal
     * @param destiny
     * @param date
     */
    public Out(Integer id, String idAnimal, String date, Boolean destiny) {
        super();
        this.id = id;
        this.idAnimal = idAnimal;
        this.date = date;
        this.destiny = destiny;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Boolean getDestiny() {
        return destiny;
    }

    public void setDestiny(Boolean destiny) {
        this.destiny = destiny;
    }

    @Override
    public String toString() {
        return "Out{" +
                "id=" + id +
                ", idAnimal='" + idAnimal + '\'' +
                ", date='" + date + '\'' +
                ", destiny=" + destiny +
                '}';
    }
}
