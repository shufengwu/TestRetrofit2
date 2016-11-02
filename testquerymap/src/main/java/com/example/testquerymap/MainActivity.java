package com.example.testquerymap;

import android.support.test.espresso.core.deps.guava.collect.ImmutableMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
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
                        .client(new OkHttpClient())
                        .build();
                AirService airService = retrofit2.create(AirService.class);
                /*Map<String,String> map = new HashMap<String, String>();
                map.put("key",AppKey);
                map.put("city","朝阳");
                map.put("province","北京");
                Call<AirBean> call = airService.groupList(map);*/
                Call<AirBean> call = airService.groupList(ImmutableMap.of("key", AppKey, "city", "朝阳","province","北京"));
                call.enqueue(new Callback<AirBean>() {
                    @Override
                    public void onResponse(Call<AirBean> call, Response<AirBean> response) {
                        final AirBean airBean = response.body();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                              show.setText("朝阳空气质量 "+airBean.getResult().get(0).getAqi()+"");
                                Toast.makeText(MainActivity.this,airBean.getResult().get(0).getAqi()+"",Toast.LENGTH_SHORT).show();
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
