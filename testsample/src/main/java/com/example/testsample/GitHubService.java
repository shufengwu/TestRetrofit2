package com.example.testsample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Shufeng.Wu on 2016/11/2.
 */

public interface GitHubService {
    @GET("users/{user}/repos")
    Call<List<JsonsRootBean>> listRepos(@Path("user") String user);
}
