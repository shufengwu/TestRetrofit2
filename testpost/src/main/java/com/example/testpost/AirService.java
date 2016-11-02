package com.example.testpost;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by wushufeng on 2016/11/3.
 */

public interface AirService {
    @POST("environment/query")
    Call<AirBean> groupList(
            @Query("key") String key,
            @Query("city") String city,
            @Query("province") String province
    );
}
