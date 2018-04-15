package com.example.freddy.cattlecontrol.Class;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Freddy on 8/4/2018.
 */

public class RetrofitClient {

    private ApiCattleCow service;
    private final Retrofit retrofit;
    private String API_URL = "https://api-cattle-control.herokuapp.com/";

    public RetrofitClient(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.service = retrofit.create(ApiCattleCow.class);
    }

    public ApiCattleCow getService() {
        return service;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public String getAPI_URL() {
        return API_URL;
    }
}
