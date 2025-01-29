package com.example.bussafe;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DashBoardFaculty extends AppCompatActivity {

    AutoCompleteTextView findbus;
    Toolbar toolbar;
    ArrayList <String> buslist = new ArrayList<>();
    ArrayList <BusModel> busModelArrayList = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dash_board_faculty);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        findbus = findViewById(R.id.auto_complete_text_view);
        toolbar = findViewById(R.id.toolbar);

        //        Linking toolbar to activity
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));


        buslist.add("Route_1-bus_1");
        buslist.add("Route_1-bus_2");
        buslist.add("Route_1-bus_3");
        buslist.add("Route_2-bus_4");
        buslist.add("Route_2-bus_5");
        buslist.add("Route_3-bus_6");
        buslist.add("Route_3-bus_7");
        buslist.add("Route_4-bus_8");
        buslist.add("Route_4-bus_9");
        buslist.add("Route_5-bus_10");



        busModelArrayList.add(new BusModel(buslist.get(0),"mayur", "123456789", 45, 45));
        busModelArrayList.add(new BusModel(buslist.get(1),"parth", "123456789", 45, 40));
        busModelArrayList.add(new BusModel(buslist.get(2),"palak", "123456789", 45, 35));
        busModelArrayList.add(new BusModel(buslist.get(3),"bp", "123456789", 45, 45, 0));
        busModelArrayList.add(new BusModel(buslist.get(4),"lucky", "123456789", 48, 44));
        busModelArrayList.add(new BusModel(buslist.get(5),"vansh", "123456789", 44, 37));
        busModelArrayList.add(new BusModel(buslist.get(6),"yash", "123456789", 45, 28));
        busModelArrayList.add(new BusModel(buslist.get(7),"kartik", "123456789", 43, 34));
        busModelArrayList.add(new BusModel(buslist.get(8),"kartikey", "123456789", 45, 42));
        busModelArrayList.add(new BusModel(buslist.get(9),"chikki", "123456789", 46, 45));

        RecyclerBusIdAdapter adapter = new RecyclerBusIdAdapter(this, busModelArrayList);
        recyclerView.setAdapter(adapter);

//        ArrayAdapter<String> adapter_search_bus = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, buslist);
//        findbus.setAdapter(adapter_search_bus);
//        findbus.setThreshold(1);
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