package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class splashActivity extends AppCompatActivity {

    ProgressBar loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

//        Animation welcome = AnimationUtils.loadAnimation(this,R.anim.loader);
//        TextView text = findViewById(R.id.wel);
//        text.startAnimation(welcome);
//        loader = findViewById(R.id.lo0000ader);
//        loader.setVisibility(View.VISIBLE);
        // Simulate a task with a delay (3 seconds)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent main = new Intent(splashActivity.this,MainActivity.class);
                startActivity(main);
                finish();
            }
        }, 3000);
    }
}