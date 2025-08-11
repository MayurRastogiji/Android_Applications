package com.example.bussafe;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
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
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(studentModelArrayList.get(position).name);

        holder.number.setText(studentModelArrayList.get(position).number);
        holder.course.setText(studentModelArrayList.get(position).course);
        holder.totalShift.setText(String.valueOf(studentModelArrayList.get(position).totalShift));
        holder.presentShift.setText(String.valueOf(studentModelArrayList.get(position).presentShift));

        SharedPreferences pref = context.getSharedPreferences("more_about_student", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        holder.view_detail.setOnClickListener(v -> {
//            holder.cardView.setVisibility(View.VISIBLE);
//            holder.recyclerView.setVisibility(View.GONE);
//            editor.putBoolean("flag", true);
//            editor.putString("name", studentModelArrayList.get(position).name);
//            editor.putString("roll_no", studentModelArrayList.get(position).number);
//            editor.putString("course", studentModelArrayList.get(position).course);
//            editor.putString("ph_no", "13465789");
//            editor.putString("address", "rhota road, meerut");

        });
//        holder.cardView.setOnClickListener(v -> {
//            holder.cardView.setVisibility(View.GONE);
//            holder.recyclerView.setVisibility(View.VISIBLE);
//        });
    }

    @Override
    public int getItemCount() {
        return studentModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, number, course,totalShift, presentShift;
        Button view_detail;
        CardView cardView;
        RecyclerView recyclerView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.StudentName);
            number = itemView.findViewById(R.id.StudentNumber);
            course = itemView.findViewById(R.id.Course);
            totalShift = itemView.findViewById(R.id.totalShift);
            presentShift = itemView.findViewById(R.id.PresentShifts);
            view_detail = itemView.findViewById(R.id.view_detail);
//            cardView = itemView.findViewById(R.id.StudentIdCard);/
//            recyclerView = itemView.findViewById(R.id.recycler_view_student);



        }
    }
}
