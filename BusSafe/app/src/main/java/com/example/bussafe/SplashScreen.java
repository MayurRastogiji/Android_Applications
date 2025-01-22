package com.example.bussafe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends login {

    Intent s2l;
    com.airbnb.lottie.LottieAnimationView welcome;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        welcome = findViewById(R.id.welcometext);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                /* Create an Intent that will start the Menu-Activity. */
                s2l = new Intent(SplashScreen.this, login.class);
                startActivity(s2l);
                finish();
            }
        }, 20000);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                /* Create an Intent that will start the Menu-Activity. */
                welcome.setVisibility(View.VISIBLE);
            }
        }, 12000);
    }
}