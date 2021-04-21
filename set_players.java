package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

public class set_players extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_players);
    }

    public void launchGame(View v){
        String message = null;
        Random r = new Random();
        String playerX = null;
        String playerO = null;
        int randInt = r.nextInt(2);
        if(randInt == 0){
            playerX = (((EditText)findViewById(R.id.editTextTextPersonName4)).getText().toString());
            playerO = (((EditText)findViewById(R.id.editTextTextPersonName3)).getText().toString());
            message = (((EditText)findViewById(R.id.editTextTextPersonName4)).getText().toString());
            message += " will begin";
        } else if (randInt == 1) {
            playerX = (((EditText)findViewById(R.id.editTextTextPersonName3)).getText().toString());
            playerO = (((EditText)findViewById(R.id.editTextTextPersonName4)).getText().toString());
            message = (((EditText)findViewById(R.id.editTextTextPersonName3)).getText().toString());
            message += " will begin";
        }
        message = message.toString();
        Intent i = new Intent(this, Game.class);
        i.putExtra("MESSAGE", message);
        i.putExtra("PLAYERX", playerX);
        i.putExtra("PLAYERO", playerO);
        startActivity(i);
    }
}