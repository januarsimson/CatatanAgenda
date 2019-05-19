package com.blogspot.ketikanmd.agenda;

import retrofit2.Call;

import retrofit2.http.POST;

public interface API {
    @POST("/sepakbola/hasil")
    Call<ResponseAgeda> getHasilAgenda();
}
