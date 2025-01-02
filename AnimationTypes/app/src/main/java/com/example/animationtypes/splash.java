package com.example.animationtypes;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

import androidx.activity.EdgeToEdge;

import com.airbnb.lottie.LottieAnimationView;

public class splash extends MainActivity {

    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        next = findViewById(R.id.next);
        next.setOnClickListener(v -> {
            Intent intent = new Intent(splash.this, MainActivity.class);
            startActivity(intent);
        });


    }
}
