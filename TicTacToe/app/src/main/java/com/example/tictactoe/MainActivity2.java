package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;



public class MainActivity2 extends MainActivity {

    Button bt11, bt12, bt13, bt21, bt22, bt23, bt31, bt32, bt33;
    TextView player1, player2, result, turn;
    int count = 0;
    String symbol_1, symbol_2, name_1, name_2, b11, b12, b13, b21, b22, b23, b31, b32, b33, player_turn;
    int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        Intent accept = getIntent();
        name_1 = accept.getStringExtra("name1");
        name_2 = accept.getStringExtra("name2");
        symbol_1 = accept.getStringExtra("symbol1");
        symbol_2 = accept.getStringExtra("symbol2");
        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
        result = findViewById(R.id.result);
        turn = findViewById(R.id.turn);

        @SuppressLint("DefaultLocale") String detail_1 = String.format("%s is playing with %s\n", name_1, symbol_1);
        player1.setText(detail_1);
        @SuppressLint("DefaultLocale") String detail_2 = String.format("%s is playing with %s\n", name_2, symbol_2);
        player2.setText(detail_2);
        player_turn = String.format("%s's turn", name_1);
        turn.setText(player_turn);
        init();
    }

    public void init() {

        bt11 = findViewById(R.id.cell11);
        bt12 = findViewById(R.id.cell12);
        bt13 = findViewById(R.id.cell13);
        bt21 = findViewById(R.id.cell21);
        bt22 = findViewById(R.id.cell22);
        bt23 = findViewById(R.id.cell23);
        bt31 = findViewById(R.id.cell31);
        bt32 = findViewById(R.id.cell32);
        bt33 = findViewById(R.id.cell33);

    }

    public String winner(String str) {
        String output = "";
        if (str.equals(symbol_1)) {
            output = String.format("%s wins", name_1);
            System.out.println(output);
        } else if (str.equals(symbol_2)) {
            output = String.format("%s wins", name_2);
        }
        return output;
    }
    @Override
    public void restart(View b){
        bt11.setText("");
        bt12.setText("");
        bt13.setText("");
        bt21.setText("");
        bt22.setText("");
        bt23.setText("");
        bt31.setText("");
        bt32.setText("");
        bt33.setText("");
        count = 0;
        result.setText("");
        turn.setText("");
    }

    public void restart(){
        bt11.setText("");
        bt12.setText("");
        bt13.setText("");
        bt21.setText("");
        bt22.setText("");
        bt23.setText("");
        bt31.setText("");
        bt32.setText("");
        bt33.setText("");
        count = 0;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void check(View v) {
        Button currentbutton = (Button) v;
        if (currentbutton.getText().toString().isEmpty()) {
            count++;
            if (flag == 0) {
                player_turn = String.format("%s's turn", name_2);
                turn.setText(player_turn);
                currentbutton.setText(symbol_1);
                flag = 1;
            } else if (flag == 1) {
                player_turn = String.format("%s's turn", name_1);
                turn.setText(player_turn);
                currentbutton.setText(symbol_2);
                flag = 0;
            }
            if (count > 4) {
                b11 = bt11.getText().toString();
                b12 = bt12.getText().toString();
                b13 = bt13.getText().toString();
                b21 = bt21.getText().toString();
                b22 = bt22.getText().toString();
                b23 = bt23.getText().toString();
                b31 = bt31.getText().toString();
                b32 = bt32.getText().toString();
                b33 = bt33.getText().toString();

                if (b11.equals(b12) && b12.equals(b13) && !b11.isEmpty()) {
                    String output = winner(b11);
                    result.setText(output);
                    restart();
                } else if (b21.equals(b22) && b22.equals(b23) && !b21.isEmpty()) {
                    result.setText(winner(b21));
                    restart();
                } else if (b31.equals(b32) && b32.equals(b33) && !b31.isEmpty()) {
                    result.setText(winner(b31));
                    restart();
                } else if (b11.equals(b21) && b21.equals(b31) && !b11.isEmpty()) {
                    result.setText(winner(b11));
                    restart();
                } else if (b12.equals(b22) && b22.equals(b32) && !b12.isEmpty()) {
                    result.setText(winner(b12));
                    restart();
                } else if (b13.equals(b23) && b23.equals(b33) && !b13.isEmpty()) {
                    result.setText(winner(b13));
                    restart();
                } else if (b11.equals(b22) && b22.equals(b33) && !b11.isEmpty()) {
                    result.setText(winner(b11));
                    restart();
                } else if (b13.equals(b22) && b22.equals(b31) && !b13.isEmpty()) {
                    result.setText(winner(b13));
                    restart();
                } else if (count == 9) {
                    result.setText("It's a draw");
                    restart();
                }
            }
        }
    }
}