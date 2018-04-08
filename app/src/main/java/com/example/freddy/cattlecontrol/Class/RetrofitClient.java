package com.example.freddy.cattlecontrol.Class;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Freddy on 8/4/2018.
 */

public class RetrofitClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api-cattle-control.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
