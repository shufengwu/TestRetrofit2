package com.example.testrtrofit2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Shufeng.Wu on 2016/11/2.
 */

interface WXTApi{
    @GET("/ifeilu-school/commInterface/{owner}")
    Call<String> getFeed(
            @Path("owner") String owner,
            @Query("sessionId") String sessionId
    );
}
