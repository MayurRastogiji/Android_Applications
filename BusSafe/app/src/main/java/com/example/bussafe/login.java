package com.example.bussafe;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class login extends AppCompatActivity {

    private Spinner spinnerRole;
    private EditText editTextUsername, editTextPassword;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        spinnerRole = findViewById(R.id.spinnerRole);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonLogin = findViewById(R.id.buttonLogin);
        toolbar = findViewById(R.id.toolbar);

//        Linking toolbar to activity
        setSupportActionBar(toolbar);


//        this command is used to set back button in toolbar
/*
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
*/
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setTitle("R.string.ComName");
//            getSupportActionBar().setSubtitle(R.string.ComTagLine);
//            Log.d("Toolbar", "Toolbar found");
//        }
//        else {
//            Toast.makeText(this, "Toolbar not found", Toast.LENGTH_SHORT).show();
//            Log.d("Toolbar", "Toolbar not found");
//        }

//        this command is used to set tittle and subtittle in toolbar
//        iski priority low hoti hai app lable se isiliye upper wala method use krte hai title set krne ke lie

//        toolbar.setTitle(R.string.ComName);
//
//        toolbar.setSubtitle(R.string.ComTagLine);

        spinnerRole.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedRole = parent.getItemAtPosition(position).toString();

                if (selectedRole.equals("Faculty") || selectedRole.equals("Passenger")) {
                    editTextUsername.setVisibility(View.VISIBLE);
                    editTextPassword.setVisibility(View.VISIBLE);
                } else {
                    editTextUsername.setVisibility(View.GONE);
                    editTextPassword.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l2m;
                String role = spinnerRole.getSelectedItem().toString();
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                if (role.equals("Faculty")) {
                    Toast.makeText(login.this, "Faculty Login Successful", Toast.LENGTH_SHORT).show();
                    l2m = new Intent(login.this, DashBoardFaculty.class);
                } else {// Handle Passenger login (if needed)
                    Toast.makeText(login.this, "Passenger Login", Toast.LENGTH_SHORT).show();
                    l2m = new Intent(login.this, MainActivity.class);
                }
                startActivity(l2m);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        new MenuInflater(this).inflate(R.menu.opt_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemID = item.getItemId();
        if (itemID == R.id.opt_1) {
            Toast.makeText(this, "New Account", Toast.LENGTH_LONG).show();
        } else if (itemID == R.id.opt_2) {
            Toast.makeText(this, "Account Balance", Toast.LENGTH_LONG).show();
        } else if (itemID == R.id.opt_3) {
            Toast.makeText(this, "Account Structure", Toast.LENGTH_LONG).show();
        }
//        this command is used to execute back command
//        if (itemID == android.R.id.home) {
//            getOnBackPressedDispatcher().onBackPressed();
//        }

        return super.onOptionsItemSelected(item);
    }
}