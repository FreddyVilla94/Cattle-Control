
package com.example.freddy.cattlecontrol.Class;

import java.util.ArrayList;

public class User {

    private String name;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private ArrayList<Farm> farms = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public User() {
        farms = new ArrayList<>();
    }

    /**
     * 
     * @param lastName
     * @param username
     * @param email
     * @param farms
     * @param name
     * @param password
     */
    public User(String name, String lastName, String email, String username, String password) {
        super();
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        farms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Farm> getFarms() {
        return farms;
    }

    public void setFarms(ArrayList<Farm> farms) {
        this.farms = farms;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
