package com.example.first_project;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText age, height, weight;
        Button calculate;
        TextView result;

        age = findViewById(R.id.age);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        calculate = findViewById(R.id.calculate);
        result = findViewById(R.id.result);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(age.getText().toString());
                double hc = Double.parseDouble(height.getText().toString());
                double w = Double.parseDouble(weight.getText().toString());

                double hm = hc/100.0;
                double bmi = w/(hm*hm);

                String category;
                if (bmi < 18.5) {
                    category = "Underweight";
                } else if (bmi >= 18.5 && bmi < 24.9) {
                    category = "Normal weight";
                } else if (bmi >= 25 && bmi < 29.9) {
                    category = "Overweight";
                } else {
                    category = "Obesity";
                }

                String bmi_result = String.format("Your BMI: %.2f\nCategory: %s\n", bmi, category);
                result.setText(bmi_result);
            }
        });
    }
}