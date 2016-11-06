package com.example.testpost;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by wushufeng on 2016/11/3.
 */

public interface AirService {
    @FormUrlEncoded
    @POST("v1/weather/query")
    Call<AirBean> groupList(
            @Field ("key") String key,
            @Field ("city") String city,
            @Field ("province") String province
    );
}
