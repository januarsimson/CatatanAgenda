package com.blogspot.ketikanmd.agenda;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    private static API REST_CLIENT;

    static {
        setupRestClient();
    }

    private RestClient() {
    }

    public static API get() {
        return REST_CLIENT;
    }

    private static void setupRestClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.43.240/").addConverterFactory(GsonConverterFactory.create()).build();

        REST_CLIENT = retrofit.create(API.class);
    }
}
