package com.example.recyler_view;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
       holder.conName.setText(arrContact.get(position).conName);
       holder.conNumber.setText(arrContact.get(position).conNumber);
       holder.conImg.setImageResource(arrContact.get(position).conImg);
       setanimation(holder.itemView, position);
       holder.row.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Dialog dialog = new Dialog(context);
               dialog.setContentView(R.layout.dialog_contact);

//               finding reference
               TextView dialogBoxText = dialog.findViewById(R.id.dialogBoxText);
               EditText dialogBoxName = dialog.findViewById(R.id.DialogBoxName);
               EditText dialogBoxNumber = dialog.findViewById(R.id.DialogBoxNumber);
               ImageView img = dialog.findViewById(R.id.conImg);
               Button update = dialog.findViewById(R.id.dialogButton);

//               updating value as per update view
               dialogBoxText.setText(R.string.update_con);
               dialogBoxName.setText(arrContact.get(position).conName);
               dialogBoxNumber.setText(arrContact.get(position).conNumber);
               update.setText(R.string.update);

               update.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       String name = "", number = "";
                       if(!dialogBoxName.getText().toString().isEmpty()){
                           name = dialogBoxName.getText().toString();
                       } else {
                           Toast.makeText(context, "Please Enter Name", Toast.LENGTH_SHORT).show();
                       }
                       if(!dialogBoxNumber.getText().toString().isEmpty()) {
                           number = dialogBoxNumber.getText().toString();
                       } else {
                           Toast.makeText(context, "Enter your number", Toast.LENGTH_SHORT).show();
                       }
                       arrContact.set(position, new conModel(arrContact.get(position).conImg, name, number));
                       notifyItemChanged(position);
                       dialog.dismiss();
                   }
               });
               dialog.show();
           }
       });
       holder.row.setOnLongClickListener(new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View v) {
               AlertDialog.Builder builder = new AlertDialog.Builder(context)
                       .setTitle("Delete Contact")
                       .setMessage("Are you sure you want to delete this contact?")
                       .setIcon(R.drawable.delete)
                       .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               arrContact.remove(position);
                               notifyItemRemoved(position);
                           }
                       })
                       .setNegativeButton("no", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {

                           }
                       });
               builder.show();
               return true;
           }
       });
    }

    @Override
    public int getItemCount() {
        return arrContact.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView conName, conNumber;
        ImageView conImg;
        LinearLayout row;
        public ViewHolder(View itemView){
            super(itemView);
            conName = itemView.findViewById(R.id.conName);
            conNumber = itemView.findViewById(R.id.conNumber);
            conImg = itemView.findViewById(R.id.conImg);
            row = itemView.findViewById(R.id.Row);
        }
        }
        int lastposition = -1;
//    this method is used to set an animation on the items that are loading in recycler view only once
    public void setanimation(View viewitem, int position){
        if(position > lastposition){
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewitem.setAnimation(animation);
            lastposition = position;
        }
    }
}

