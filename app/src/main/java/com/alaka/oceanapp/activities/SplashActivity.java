package com.alaka.oceanapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.alaka.oceanapp.R;
import com.alaka.oceanapp.services.MyService;


public class SplashActivity extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, DashboardActivity.class));
            }
        };
        handler.postDelayed(runnable,3000);
        }


    @Override
    protected void onStart() {
        super.onStart();
        startService(new Intent(this, MyService.class));
    }
}

