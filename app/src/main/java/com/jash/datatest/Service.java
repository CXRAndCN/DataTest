package com.jash.datatest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("article/list/video")
    Call<Entry> getEntry();
}
