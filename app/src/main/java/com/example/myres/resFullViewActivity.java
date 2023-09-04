package com.example.myres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class resFullViewActivity extends AppCompatActivity {
    Button btnReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_full_view);
        btnReview = findViewById(R.id.btnReviews);

        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toReview = new Intent(resFullViewActivity.this, ReviewActivity.class);
                startActivity(toReview);
            }
        });
    }
}