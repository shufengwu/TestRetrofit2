package com.example.wushufeng.testretrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wushufeng.testretrofit2.Idiom;
import com.example.wushufeng.testretrofit2.IdiomService;
import com.sfw.retrofit.R;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final String AppKey = "12c5afd699940";

    private TextView show;
    private Button button1;
    private Button button2;
    private Call<Idiom> call = null;
    IdiomService idiomService;
    Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (TextView)findViewById(R.id.show);
        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
        retrofit = new Retrofit.Builder()
                .baseUrl("http://apicloud.mob.com/appstore/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        idiomService = retrofit.create(IdiomService.class);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        call = idiomService.getIdiom(AppKey, "刻舟求剑");
                        try{
                            final Response<Idiom> response = call.execute(); // 同步
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    final Idiom idiom = response.body();
                                    System.out.println(idiom.getResult().getPretation());
                                    show.setText(idiom.getResult().getPretation());
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                break;
            case R.id.button2:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl("http://apicloud.mob.com/appstore/")
                                .addConverterFactory(ScalarsConverterFactory.create())
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
                        IdiomService idiomService = retrofit.create(IdiomService.class);
                        call = idiomService.getIdiom(AppKey, "守株待兔");
                        call.enqueue(new Callback<Idiom>() {
                            @Override
                            public void onResponse(Call<Idiom> call, Response<Idiom> response) {
                                final Idiom idiom = response.body();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        System.out.println(idiom.getResult().getPretation());
                                        show.setText(idiom.getResult().getPretation());
                                    }
                                });
                            }

                            @Override
                            public void onFailure(Call<Idiom> call, Throwable t) {

                            }
                        });

                    }
                }).start();
                break;
        }
    }
}
