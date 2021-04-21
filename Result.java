package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent i = getIntent();
        String result = i.getStringExtra("RESULT");
        ((TextView)(findViewById(R.id.textView4))).setText(result);
    }


    public void relaunchGame(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }
}
