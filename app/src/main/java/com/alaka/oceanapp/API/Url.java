package com.alaka.oceanapp.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Url {
    private static Retrofit retrofit;
    public static String cookie = "";
    public static String uid = "";

    public static APIEndpoints getEndPoints() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                   .baseUrl("http://10.0.2.2:3000/")
//                       .baseUrl("http://172.26.0.25:3000/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(APIEndpoints.class);
    }
}

