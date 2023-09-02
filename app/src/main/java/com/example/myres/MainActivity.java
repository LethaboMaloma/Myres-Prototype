package com.example.myres;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView resRecyclerView;
    private RecyclerView.Adapter resAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewRes();
    }

    private void recyclerViewRes(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        resRecyclerView = findViewById(R.id.resRecyclerView);
        resRecyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<Res> allRes = new ArrayList<>();
        String resName = "Yale Village";
        double resRating = 4.5;
        String resDesciption = "Yale Village offers massive outdoor spaces, from beautiful gardens, numerous sports fields to a swimming pool. There are countless outdoor chill areas, to quietly read a book, study or even just catch up with friends. When you live at Yale Village, all you need to worry about is getting good grades!"
        String resLocation = "Parktown";
        int resDistance = 100;
        double monthlyRent = 5900;
        ArrayList<Integer> amenities = new ArrayList<>();
        ArrayList<Review> reviews = new ArrayList<>();

        allRes.add(new Res(resName, resRating, resLocation, resDesciption, monthlyRent, resDistance, amenities, reviews));

        resAdapter=new ResAdapter(allRes);
        resRecyclerView.setAdapter(resAdapter);
    }
}