package com.example.otimus.retrolisting.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Otimus on 10/31/2016.
 */
public class ApiClient {

    public static final String BASE_URL="http://jsonplaceholder.typicode.com/";

    private static Retrofit retrofit=null;

    public static Retrofit getClient(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
