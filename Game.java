package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Game extends AppCompatActivity {

    private String currentPlayer = "x";
    private int squaresLeft = 9;
    String playerXX;
    String playerOO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent i = getIntent();
        String firstPlayer = i.getStringExtra("MESSAGE");
        ((TextView)(findViewById(R.id.textView3))).setText(firstPlayer);
        playerXX = i.getStringExtra("PLAYERX");
        playerOO = i.getStringExtra("PLAYERO");
    }

    public void relaunchGame(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }

    public void play(View v) {
        squaresLeft--;
        v.setEnabled(false);
        Button b = (Button) v;
        b.setText(currentPlayer);
        String winner = null;
        String currentPlayerName = null;

        if ((((Button) findViewById(R.id.button4)).getText().toString().equals(currentPlayer) &&
                ((Button) findViewById(R.id.button5)).getText().toString().equals(currentPlayer) &&
                ((Button) findViewById(R.id.button6)).getText().toString().equals(currentPlayer)) ||
                (((Button) findViewById(R.id.button7)).getText().toString().equals(currentPlayer) &&
                        ((Button) findViewById(R.id.button8)).getText().toString().equals(currentPlayer) &&
                        ((Button) findViewById(R.id.button9)).getText().toString().equals(currentPlayer)) ||
                (((Button) findViewById(R.id.button10)).getText().toString().equals(currentPlayer) &&
                        ((Button) findViewById(R.id.button11)).getText().toString().equals(currentPlayer) &&
                        ((Button) findViewById(R.id.button12)).getText().toString().equals(currentPlayer)) ||
                (((Button) findViewById(R.id.button4)).getText().toString().equals(currentPlayer) &&
                        ((Button) findViewById(R.id.button7)).getText().toString().equals(currentPlayer) &&
                        ((Button) findViewById(R.id.button10)).getText().toString().equals(currentPlayer)) ||
                (((Button) findViewById(R.id.button5)).getText().toString().equals(currentPlayer) &&
                        ((Button) findViewById(R.id.button8)).getText().toString().equals(currentPlayer) &&
                        ((Button) findViewById(R.id.button11)).getText().toString().equals(currentPlayer)) ||
                (((Button) findViewById(R.id.button6)).getText().toString().equals(currentPlayer) &&
                        ((Button) findViewById(R.id.button9)).getText().toString().equals(currentPlayer) &&
                        ((Button) findViewById(R.id.button12)).getText().toString().equals(currentPlayer)) ||
                (((Button) findViewById(R.id.button4)).getText().toString().equals(currentPlayer) &&
                        ((Button) findViewById(R.id.button8)).getText().toString().equals(currentPlayer) &&
                        ((Button) findViewById(R.id.button12)).getText().toString().equals(currentPlayer)) ||
                (((Button) findViewById(R.id.button6)).getText().toString().equals(currentPlayer) &&
                        ((Button) findViewById(R.id.button8)).getText().toString().equals(currentPlayer) &&
                        ((Button) findViewById(R.id.button10)).getText().toString().equals(currentPlayer))) {
            winner = currentPlayer;
        } else if (squaresLeft == 0) {
            winner = "DRAW";
        }
        if(winner != null){
            String result = null;
            if(winner.equals("x")){
                result = playerXX;
            } else if(winner.equals("o")){
                result = playerOO;
            } else {
                result = "DRAW";
            }
            Intent intent = new Intent(this, Result.class);
            intent.putExtra("RESULT", result);
            startActivity(intent);
        } else {
            if(currentPlayer.equals("x")){
                currentPlayerName = playerOO;
            }else{
                currentPlayerName = playerXX;
            }

            if (currentPlayer.equals("x")) {
                currentPlayer = "o";
            } else {
                currentPlayer = "x";
            }

            ((TextView)(findViewById(R.id.textView3))).setText(currentPlayerName);
        }
    }
}

