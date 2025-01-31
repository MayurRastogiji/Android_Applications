package com.example.trying;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.trying.R;

public class MainActivity2 extends AppCompatActivity {

    TextView text;
    int i = 1;
    Animation moveAlpha,moveTranslate, moveRotate, moveScale, moveZoom;
    Button btntranslate, btnalpha, btnrotate, btnscale,btnzoom, btnlottie;
//    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);


        moveAlpha = AnimationUtils.loadAnimation(this,R.anim.alphaa);
        moveScale = AnimationUtils.loadAnimation(this,R.anim.scale);
        moveRotate = AnimationUtils.loadAnimation(this,R.anim.rotate);
        moveTranslate = AnimationUtils.loadAnimation(this,R.anim.translate);
        moveZoom = AnimationUtils.loadAnimation(this,R.anim.zoom);
        text = findViewById(R.id.centerText);
        btnalpha = findViewById(R.id.alpha);
        btnrotate = findViewById(R.id.rotate);
        btnscale = findViewById(R.id.scale);
        btntranslate = findViewById(R.id.translate);
        btnlottie = findViewById(R.id.lottie);
        btnzoom = findViewById(R.id.zoom);

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
        btnzoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { text.startAnimation(moveZoom); }
        });

        btnlottie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                lottie = findViewById(R.id.hand);
//                lottie.playAnimation();
//                lottie.loop(true);
                if(i%2 == 0){
                    text.setText("yuhuhuhu");
                    i++;
                }
                else {
                    text.setText("hello world!");
                    i++;
                }

            }

        });

    }
}