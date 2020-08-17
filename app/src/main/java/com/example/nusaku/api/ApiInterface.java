package com.example.nusaku.api;

import com.example.nusaku.models.AccessToken;
import com.example.nusaku.models.DestinationTypeData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("getDestinationType")
    Call<ArrayList<DestinationTypeData>> getDestinationType();
}
