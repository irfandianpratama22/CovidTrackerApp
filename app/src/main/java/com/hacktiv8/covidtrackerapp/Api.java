package com.hacktiv8.covidtrackerapp;

import com.hacktiv8.covidtrackerapp.Covid;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://disease.sh/";

    @GET("v3/covid-19/all")
    Call<Covid> getCovidAll();
}
