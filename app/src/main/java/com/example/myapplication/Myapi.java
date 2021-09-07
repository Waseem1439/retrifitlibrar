package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Myapi {
    @GET("posts")
    Call<List<Model>> getpostlist();
}
