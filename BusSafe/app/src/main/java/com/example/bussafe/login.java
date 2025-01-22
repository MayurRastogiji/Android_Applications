package com.example.bussafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login extends AppCompatActivity {

    private Spinner spinnerRole;
    private EditText editTextUsername, editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        spinnerRole = findViewById(R.id.spinnerRole);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

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
                    l2m = new Intent(login.this,MainActivity.class);
                    startActivity(l2m);
                } else {
                    // Handle Passenger login (if needed)
                    Toast.makeText(login.this, "Passenger Login", Toast.LENGTH_SHORT).show();
                    l2m = new Intent(login.this,MainActivity.class);
                    startActivity(l2m);
                }
            }
        });
    }
}