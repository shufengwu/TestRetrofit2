package com.example.testsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.testsample.GitHubService;
import com.example.testsample.JsonsRootBean;
import com.sfw.retrofit.testsample.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api.github.com/")
                        //.addConverterFactory(ScalarsConverterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                GitHubService service = retrofit.create(GitHubService.class);
                final Call<List<JsonsRootBean>> repos = service.listRepos("shufengwu");
                repos.enqueue(new Callback<List<JsonsRootBean>>() {
                    @Override
                    public void onResponse(Call<List<JsonsRootBean>> call, Response<List<JsonsRootBean>> response) {
                        final List<JsonsRootBean> list = response.body();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ((TextView)findViewById(R.id.show)).setText(list.get(0).getDescription().toString());
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<List<JsonsRootBean>> call, Throwable t) {

                    }
                });
            }
        }).start();
    }
}
