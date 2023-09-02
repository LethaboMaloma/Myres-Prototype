package com.example.myres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Startup_page3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_page3);

        Button btnMainPage = findViewById(R.id.btnMainPg);
        btnMainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toSignUp = new Intent(Startup_page3.this, LoginActivity.class);
                startActivity(toSignUp);
            }
    });
    }
}