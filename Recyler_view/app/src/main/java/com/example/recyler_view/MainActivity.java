package com.example.recyler_view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    reference to the button which is created in activity_main.xml
    FloatingActionButton mainButton;

//    reference to the RecConAdapter class which is created in RecConAdapter.java
    RecConAdapter adapter;

//    reference to the RecyclerView which is created in activity_main.xml
    RecyclerView recContact;

//    created arraylist of the datatype mentioned in conModel.java
    ArrayList<conModel> arrContact = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mainButton = findViewById(R.id.mainButton);

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                creating a dialog
                Dialog dialog = new Dialog(MainActivity.this);

//                setting our xml file to the dialog
                dialog.setContentView(R.layout.dialog_contact);
                EditText dialogBoxName = dialog.findViewById(R.id.DialogBoxName);
                EditText dialogBoxNumber = dialog.findViewById(R.id.DialogBoxNumber);
                Button update = dialog.findViewById(R.id.dialogButton);
                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = "", number = "";
                        if(!dialogBoxName.getText().toString().isEmpty()){
                            name = dialogBoxName.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
                        }
                        if(!dialogBoxNumber.getText().toString().isEmpty()) {
                            number = dialogBoxNumber.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Enter your number", Toast.LENGTH_SHORT).show();
                        }

//                        R.drawable.img is used below because we are not taking image from user

                        arrContact.add(new conModel(R.drawable.img, name, number));
                        adapter.notifyItemInserted(arrContact.size());
                        recContact.smoothScrollToPosition(arrContact.size());
                        dialog.dismiss();

                    }
                });

                dialog.show();
            }
        });

        recContact = findViewById(R.id.contact);

        recContact.setLayoutManager(new LinearLayoutManager(this));

        arrContact.add(new conModel(R.drawable.img, "Shivi Rastogi", "1234567890"));
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

        adapter = new RecConAdapter(this, arrContact);
        recContact.setAdapter(adapter);

    }
}