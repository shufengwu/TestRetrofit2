package com.example.testpost;

import android.support.test.espresso.core.deps.guava.collect.ImmutableMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URLEncoder;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String AppKey = "12c5afd699940";
    private TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (TextView)findViewById(R.id.show);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Retrofit retrofit2 = new Retrofit.Builder()
                            .baseUrl("http://apicloud.mob.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    AirService airService = retrofit2.create(AirService.class);
                    /*Air air = new Air();
                    air.setKey(AppKey);
                    air.setCity("朝阳");
                    air.setProvince("北京");*/
                    Call<AirBean> call = airService.groupList("12c5afd699940","朝阳" ,"北京");
                    call.enqueue(new Callback<AirBean>() {
                        @Override
                        public void onResponse(Call<AirBean> call, Response<AirBean> response) {
                            final AirBean airBean = response.body();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    show.setText(airBean.getResult().get(0).getDressingIndex());
                                    /*for (int i=0;i<airBean.getResult().size();i++){
                                        System.out.println(airBean.getResult().get(i));
                                    }*/
                                    //show.setText(airBean.getResult().get(0).getQuality());
                                }
                            });
                        }

                        @Override
                        public void onFailure(Call<AirBean> call, Throwable t) {

                        }
                    });
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
