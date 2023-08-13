package com.example.myres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Res extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button reviewbutton = (Button) findViewById(R.id.reviewbtn);
        reviewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thirdscrn = new Intent(Res.this, ReviewActivity.class);
                startActivity(thirdscrn);
            }
        });
    }
}