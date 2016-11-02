package com.example.wushufeng.testretrofit2;

import com.example.wushufeng.testretrofit2.Idiom;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Shufeng.Wu on 2016/11/2.
 */

public interface IdiomService {
    @GET("idiom/query")
    Call<Idiom> getIdiom(
            @Query("key") String key,
            @Query("name") String name
    );
}
