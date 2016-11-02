package com.example.testrtrofit2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Shufeng.Wu on 2016/11/2.
 */

public interface IWeather {
    @GET("/v3/weather/now.json")
    Call<WeatherBean> weather(@Query("key") String key, @Query("location") String location);
}
