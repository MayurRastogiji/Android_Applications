package com.example.bussafe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.widget.Toast.*;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class DashBoardBus extends AppCompatActivity{
    Button total, present, absent;
    Toolbar toolbar;
    TextView totalCount, PresentCount, AbsentCount;
RecyclerView recyclerView;
ArrayList<StudentModel> StudentModelArrayList = new ArrayList<>();
ArrayList<StudentModel> StudentModelPresentArrayList = new ArrayList<>();
ArrayList<StudentModel> StudentModelAbsentArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board_bus);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        totalCount = findViewById(R.id.TotalCount);
        PresentCount = findViewById(R.id.PresentCount);
        AbsentCount = findViewById(R.id.AbsentCount);
        total = findViewById(R.id.total);
        present = findViewById(R.id.present);
        absent = findViewById(R.id.absent);
        toolbar = findViewById(R.id.toolbarBus);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        StudentModelArrayList.add(new StudentModel("Mayur", "123456789", "CSE", 4, 3, 0));
        StudentModelArrayList.add(new StudentModel("bp", "123456789", "CSE", 4, 3, 0));
        StudentModelArrayList.add(new StudentModel("lucky", "123456789", "CSE", 4, 4, 1));
        StudentModelArrayList.add(new StudentModel("Parth", "123456789", "CSE", 4, 3, 0));
        StudentModelArrayList.add(new StudentModel("a", "123456789", "CSE", 4, 3, 0));
        StudentModelArrayList.add(new StudentModel("b", "123456789", "CSE", 4, 4, 1));
        StudentModelArrayList.add(new StudentModel("c", "123456789", "CSE", 4, 3, 1));
        StudentModelArrayList.add(new StudentModel("d", "123456789", "CSE", 4, 3, 0));
        StudentModelArrayList.add(new StudentModel("e", "123456789", "CSE", 4, 4, 1));
        StudentModelArrayList.add(new StudentModel("f", "123456789", "CSE", 4, 3, 0));
        StudentModelArrayList.add(new StudentModel("g", "123456789", "CSE", 4, 3, 1));
        StudentModelArrayList.add(new StudentModel("h", "123456789", "CSE", 4, 3, 0));
        StudentModelArrayList.add(new StudentModel("i", "123456789", "CSE", 4, 3, 1));

        RecyclerStudentAdapter adapter = new RecyclerStudentAdapter(this, StudentModelArrayList);
        recyclerView.setAdapter(adapter);

        for(int i = 0; i < StudentModelArrayList.size(); i++) {
            if (StudentModelArrayList.get(i).present == 1) {
                StudentModelPresentArrayList.add(new StudentModel(StudentModelArrayList.get(i).name, StudentModelArrayList.get(i).number, StudentModelArrayList.get(i).course, StudentModelArrayList.get(i).totalShift, StudentModelArrayList.get(i).presentShift, StudentModelArrayList.get(i).present));
            } else {
                StudentModelAbsentArrayList.add(new StudentModel(StudentModelArrayList.get(i).name, StudentModelArrayList.get(i).number, StudentModelArrayList.get(i).course, StudentModelArrayList.get(i).totalShift, StudentModelArrayList.get(i).presentShift, StudentModelArrayList.get(i).present));
            }
        }

        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setAdapter(adapter);
            }
        });
        present.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerStudentAdapter adapterPresent = new RecyclerStudentAdapter(DashBoardBus.this, StudentModelPresentArrayList);
                recyclerView.setAdapter(adapterPresent);
            }
        });
        absent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerStudentAdapter adapterPresent = new RecyclerStudentAdapter(DashBoardBus.this, StudentModelAbsentArrayList);
                recyclerView.setAdapter(adapterPresent);
            }
        });
        totalCount.setText(String.valueOf(StudentModelArrayList.size()));
        PresentCount.setText(String.valueOf(StudentModelPresentArrayList.size()));
        AbsentCount.setText(String.valueOf(StudentModelAbsentArrayList.size()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.opt_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemID = item.getItemId();
        if (itemID == R.id.opt_1) {
            makeText(this, "New Account", LENGTH_LONG).show();
        } else if (itemID == R.id.opt_2) {
            makeText(this, "Account Balance", LENGTH_LONG).show();
        } else if (itemID == R.id.opt_3) {
            makeText(this, "Account Structure", LENGTH_LONG).show();
        }
//        this command is used to execute back command
//        if (itemID == android.R.id.home) {
//            getOnBackPressedDispatcher().onBackPressed();
//        }

        return super.onOptionsItemSelected(item);
    }
}