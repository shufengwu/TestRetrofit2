package com.example.testpost;

import android.support.test.espresso.core.deps.guava.collect.ImmutableMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final String AppKey = "12c5afd699940";
    private TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (TextView)findViewById(R.id.show);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Retrofit retrofit2 = new Retrofit.Builder()
                        .baseUrl("http://apicloud.mob.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                AirService airService = retrofit2.create(AirService.class);
                /*Map<String,String> map = new HashMap<String, String>();
                map.put("key",AppKey);
                map.put("city","朝阳");
                map.put("province","北京");
                Call<AirBean> call = airService.groupList(map);*/
                Call<AirBean> call = airService.groupList("12c5afd699940", "朝阳","北京");
                call.enqueue(new Callback<AirBean>() {
                    @Override
                    public void onResponse(Call<AirBean> call, final Response<AirBean> response) {
                        final AirBean airBean = response.body();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                show.setText(response.body().getMsg()+"");
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<AirBean> call, Throwable t) {
                        Log.d("cylog", "Error" + t.toString());
                    }
                });
            }
        }).start();
    }
}
