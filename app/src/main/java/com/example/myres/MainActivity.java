package com.example.myres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton to_discription = (ImageButton) findViewById(R.id.imageButton1);
        to_discription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondcrn = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(secondcrn);
            }
        });
    }


}