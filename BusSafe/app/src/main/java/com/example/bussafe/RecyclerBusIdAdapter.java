package com.example.bussafe;

import static android.view.LayoutInflater.from;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerBusIdAdapter extends RecyclerView.Adapter<RecyclerBusIdAdapter.ViewHolder> {
    Context context;
    ArrayList<BusModel> busModelArrayList;
    RecyclerBusIdAdapter(Context context, ArrayList<BusModel> arrayList){
        this.context = context;
        this.busModelArrayList = arrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bus_info_card, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.busId.setText(busModelArrayList.get(position).busId);
        holder.facultyName.setText(busModelArrayList.get(position).facultyName);
        holder.facultyNumber.setText(busModelArrayList.get(position).facultyNumber);
        holder.totalStudent.setText(String.valueOf(busModelArrayList.get(position).totalStudent));
        holder.presentStudent.setText(String.valueOf(busModelArrayList.get(position).presentStudent));
        holder.absentStudent.setText(String.valueOf(busModelArrayList.get(position).absentStudent));

    }

    @Override
    public int getItemCount() {
        return busModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView busId, facultyName, facultyNumber, totalStudent, presentStudent, absentStudent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            busId = itemView.findViewById(R.id.BusCardId);
            facultyName = itemView.findViewById(R.id.FacultyName);
            facultyNumber = itemView.findViewById(R.id.FacultyNumber);
            totalStudent = itemView.findViewById(R.id.TotalStudent);
            presentStudent = itemView.findViewById(R.id.PresentStudent);
            absentStudent = itemView.findViewById(R.id.AbsentStudent);
        }
    }
}
