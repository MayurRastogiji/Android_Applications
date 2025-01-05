package com.example.recyler_view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

RecyclerView recContact;
ArrayList<conModel> arrContact = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        recContact = findViewById(R.id.contact);

        recContact.setLayoutManager(new LinearLayoutManager(this));

        arrContact.add(new conModel(R.drawable.img, "Mayur Rastogi", "1234567890"));
        arrContact.add(new conModel(R.drawable.img1, "Lucky Tomar", "1234567890"));
        arrContact.add(new conModel(R.drawable.img, "Mayur Rastogi", "1234567890"));
        arrContact.add(new conModel(R.drawable.img1, "Parth Juneja", "1234567890"));
        arrContact.add(new conModel(R.drawable.img, "Mayur Rastogi", "1234567890"));
        arrContact.add(new conModel(R.drawable.img1, "Yash Rastogi", "1234567890"));
        arrContact.add(new conModel(R.drawable.img, "Mayur Rastogi", "1234567890"));
        arrContact.add(new conModel(R.drawable.img1, "Kartikey Sharma", "1234567890"));
        arrContact.add(new conModel(R.drawable.img, "Mayur Rastogi", "1234567890"));
        arrContact.add(new conModel(R.drawable.img1, "Mayur Rastogi", "1234567890"));
        arrContact.add(new conModel(R.drawable.img, "Mayur Rastogi", "1234567890"));
        arrContact.add(new conModel(R.drawable.img1, "Mayur Rastogi", "1234567890"));
        arrContact.add(new conModel(R.drawable.img, "Mayur Rastogi", "1234567890"));
        arrContact.add(new conModel(R.drawable.img1, "Mayur Rastogi", "1234567890"));
        arrContact.add(new conModel(R.drawable.img, "Mayur Rastogi", "1234567890"));
        arrContact.add(new conModel(R.drawable.img1, "Mayur Rastogi", "1234567890"));

        RecConAdapter adapter = new RecConAdapter(this, arrContact);
        recContact.setAdapter(adapter);

    }
}