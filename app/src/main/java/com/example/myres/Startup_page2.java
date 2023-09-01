package com.example.myres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Startup_page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_page2);
        Button btnStartUpPage2 = findViewById(R.id.btnStartUpPage2);
        btnStartUpPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toSignUp = new Intent(Startup_page2.this, Startup_page3.class);
                startActivity(toSignUp);
            }
    });
    }
}