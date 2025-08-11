// CalendarFragment.java
package com.example.bussafe; // Replace with your package name

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CalenderFragment extends Fragment {

    private CalendarView calendarView;
    private TextView selectedDateTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calender, container, false);

        calendarView = view.findViewById(R.id.calendarView);
        selectedDateTextView = view.findViewById(R.id.selectedDateTextView);

        calendarView.setOnDateChangeListener((view1, year, month, dayOfMonth) -> {
            // Month is 0-indexed, so add 1
            month++;

            String formattedDate = formatDate(year, month, dayOfMonth);
            selectedDateTextView.setText(formattedDate);


            // Here you can add code to fetch and display events for the selected date
            // ...
        });

        return view;
    }

    private String formatDate(int year, int month, int dayOfMonth) {
        // Use SimpleDateFormat for more flexible formatting
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, yyyy", Locale.getDefault());

        Date date = new Date(year - 1900, month - 1, dayOfMonth); // Date is deprecated, but works here
        return sdf.format(date);
    }
}