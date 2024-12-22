package com.example.animationtypes;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView text;
        Animation moveAlpha,moveTranslate, moveRotate, moveScale;
    Button btntranslate, btnalpha, btnrotate, btnscale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        moveAlpha = AnimationUtils.loadAnimation(this,R.anim.alphaa);
        moveScale = AnimationUtils.loadAnimation(this,R.anim.scale);
        moveRotate = AnimationUtils.loadAnimation(this,R.anim.rotate);
        moveTranslate = AnimationUtils.loadAnimation(this,R.anim.translate);
        text = findViewById(R.id.centerText);
        btnalpha = findViewById(R.id.alpha);
        btnrotate = findViewById(R.id.rotate);
        btnscale = findViewById(R.id.scale);
        btntranslate = findViewById(R.id.translate);

        btnalpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.startAnimation(moveAlpha);
            }
        });
        btntranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.startAnimation(moveTranslate);
            }
        });
        btnrotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.startAnimation(moveRotate);
            }
        });
        btnscale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.startAnimation(moveScale);
            }
        });

    }
}