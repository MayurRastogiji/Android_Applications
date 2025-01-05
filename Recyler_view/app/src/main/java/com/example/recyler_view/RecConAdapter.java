package com.example.recyler_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecConAdapter extends RecyclerView.Adapter<RecConAdapter.ViewHolder>{
    Context context;
    ArrayList<conModel> arrContact;

    public RecConAdapter(Context context, ArrayList<conModel> arrContact){
    this.context = context;
    this.arrContact = arrContact;
}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.contact_row, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.conName.setText(arrContact.get(position).conName);
       holder.conNumber.setText(arrContact.get(position).conNumber);
       holder.conImg.setImageResource(arrContact.get(position).conImg);
    }

    @Override
    public int getItemCount() {
        return arrContact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView conName, conNumber;
        ImageView conImg;
        public ViewHolder(View itemView){
            super(itemView);
            conName = itemView.findViewById(R.id.conName);
            conNumber = itemView.findViewById(R.id.conNumber);
            conImg = itemView.findViewById(R.id.conImg);
        }
        }
}
