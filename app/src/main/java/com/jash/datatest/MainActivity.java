package com.jash.datatest;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.jash.datatest.databinding.ActivityMainBinding;

import org.xutils.x;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<Entry> {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        x.Ext.init(getApplication());
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        new Retrofit.Builder().baseUrl("http://m2.qiushibaike.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Service.class)
                .getEntry()
                .enqueue(this);
    }

    @Override
    public void onResponse(Call<Entry> call, Response<Entry> response) {
        binding.setEntry(response.body());
    }

    @Override
    public void onFailure(Call<Entry> call, Throwable t) {
        t.printStackTrace();
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
