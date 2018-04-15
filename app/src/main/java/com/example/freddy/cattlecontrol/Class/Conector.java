package com.example.freddy.cattlecontrol.Class;

/**
 * Created by Freddy on 14/4/2018.
 */

public class Conector {

    private static User user = null;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Conector.user = user;
    }
}
