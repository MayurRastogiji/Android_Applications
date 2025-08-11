package com.example.bussafe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.activity.EdgeToEdge;


@SuppressLint("CustomSplashScreen")
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
        new Handler().postDelayed(() -> {
            /* Create an Intent that will start the Menu-Activity.
                s2l = new Intent(SplashScreen.this, login.class);
                startActivity(s2l);
                finish();
                */

            SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
            boolean check = pref.getBoolean("flag", false);
            String role = pref.getString("role", "null");
            if(check){
                if(role.equals("Faculty")) {
                    s2l = new Intent(SplashScreen.this, DashBoardFaculty.class);
                } else if (role.equals("Passenger")) {
                    s2l = new Intent(SplashScreen.this, MainActivity.class);
                }
            } else
                s2l = new Intent(SplashScreen.this, login.class);
            startActivity(s2l);
        }, 20000); // wait for 20 seconds (20000 milliseconds)
        new Handler().postDelayed(() -> {
            /* Create an Intent that will start the Menu-Activity. */
            welcome.setVisibility(View.VISIBLE);
        }, 12000); // wait for 12 seconds(12000 milliseconds)
    }
}