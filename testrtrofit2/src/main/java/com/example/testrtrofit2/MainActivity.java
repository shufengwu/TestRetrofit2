package com.example.testrtrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.testrtrofit2.IWeather;
import com.example.testrtrofit2.WeatherBean;
import com.sfw.retrofit.testretrofit2.R;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView show;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (TextView)findViewById(R.id.show);
        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==button1){
            new Thread(new Runnable() {
                @Override
                public void run() {

                    Retrofit retrofit2 = new Retrofit.Builder()
                            .baseUrl("https://api.thinkpage.cn")
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(new OkHttpClient())
                            .build();
                    IWeather iWeather = retrofit2.create(IWeather.class);
                    Call<WeatherBean> call = iWeather.weather("rot2enzrehaztkdk","beijing");
                    call.enqueue(new Callback<WeatherBean>() {
                        @Override
                        public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                            final WeatherBean weatherBean = response.body();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    ((TextView)findViewById(R.id.show)).setText(weatherBean.getResults().get(0).getNow().getTemperature()+"");
                                }
                            });
                        }

                        @Override
                        public void onFailure(Call<WeatherBean> call, Throwable t) {
                            Log.d("cylog", "Error" + t.toString());
                        }
                    });
                }
            }).start();

        }
    }
}
