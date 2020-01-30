package com.example.task.data.remote;


import com.example.task.data.remote.model.ImageResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("v1")
    Call<ImageResponse> getSearchImages(@Query("q") String searchText, @Query("cx") String cx, @Query("key") String key);
}
