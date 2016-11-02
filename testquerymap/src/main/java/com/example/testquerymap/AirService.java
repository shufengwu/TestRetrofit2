package com.example.testquerymap;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by wushufeng on 2016/11/3.
 */

public interface AirService {
    @GET("environment/query")
    Call<AirBean> groupList(@QueryMap Map<String, String> options);
}
