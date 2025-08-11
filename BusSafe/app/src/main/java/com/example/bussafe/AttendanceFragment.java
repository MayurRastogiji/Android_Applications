package com.example.bussafe; // Make sure this matches your package name

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AttendanceFragment extends Fragment {

    private AttendanceBar morningBar;
    private AttendanceBar eveningBar;
    private AttendanceBar totalBar;
    private TextView morningPercentage;
    private TextView eveningPercentage;
    private TextView totalPercentage;
    private ImageButton refreshButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attendance, container, false); // Use your fragment layout

        // Initialize views
        morningBar = view.findViewById(R.id.morning_bar);
        eveningBar = view.findViewById(R.id.evening_bar);
        totalBar = view.findViewById(R.id.total_bar);
        morningPercentage = view.findViewById(R.id.morning_percentage);
        eveningPercentage = view.findViewById(R.id.evening_percentage);
        totalPercentage = view.findViewById(R.id.total_percentage);
        refreshButton = view.findViewById(R.id.refresh_button);

        // Set initial progress (example)
        morningBar.setProgress(80);
        eveningBar.setProgress(90);
        totalBar.setProgress(85);

        // Set initial percentages (example)
        morningPercentage.setText("80%");
        eveningPercentage.setText("90%");
        totalPercentage.setText("85%");

        // Set refresh button click listener
        refreshButton.setOnClickListener(v -> {
            // Replace with your actual data fetching logic
            int newMorning = (int) (Math.random() * 100);
            int newEvening = (int) (Math.random() * 100);
            int newTotal = (newMorning + newEvening)/2;

            morningBar.setProgress(newMorning);
            eveningBar.setProgress(newEvening);
            totalBar.setProgress(newTotal);

            morningPercentage.setText(String.format("%d%%", newMorning));
            eveningPercentage.setText(String.format("%d%%", newEvening));
            totalPercentage.setText(String.format("%d%%", newTotal));
        });

        return view;
    }
}