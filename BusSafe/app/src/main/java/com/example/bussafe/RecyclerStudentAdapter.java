package com.example.bussafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerStudentAdapter extends RecyclerView.Adapter<RecyclerStudentAdapter.ViewHolder> {
    Context context;
    ArrayList<StudentModel> studentModelArrayList;
    RecyclerStudentAdapter(Context context, ArrayList<StudentModel> arrayList){
        this.context = context;
        this.studentModelArrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.student_info_card, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(studentModelArrayList.get(position).name);
        holder.number.setText(studentModelArrayList.get(position).number);
        holder.course.setText(studentModelArrayList.get(position).course);
        holder.totalShift.setText(String.valueOf(studentModelArrayList.get(position).totalShift));
        holder.presentShift.setText(String.valueOf(studentModelArrayList.get(position).presentShift));
    }

    @Override
    public int getItemCount() {
        return studentModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, number, course,totalShift, presentShift;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.StudentName);
            number = itemView.findViewById(R.id.StudentNumber);
            course = itemView.findViewById(R.id.Course);
            totalShift = itemView.findViewById(R.id.totalShift);
            presentShift = itemView.findViewById(R.id.PresentShifts);
        }
    }
}
