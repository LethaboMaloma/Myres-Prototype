package com.example.myres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //image button
        ImageButton to_discription = (ImageButton) findViewById(R.id.imageButton1);
        to_discription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toRes = new Intent(MainActivity.this, Res.class);
                startActivity(toRes);
            }
        });
    }
}