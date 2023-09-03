package com.example.myres;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class ReviewActivity extends AppCompatActivity {
    private EditText reviewEditText;
    private RecyclerView reviewRecyclerView;
    private ArrayList<Review> reviewList;
    private ReviewAdapter reviewAdapter;
    private Button refresh;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        reviewEditText = findViewById(R.id.review_edittext);
        reviewRecyclerView = findViewById(R.id.review_recycler_view);
        refresh = findViewById(R.id.refresh);
        reviewList = new ArrayList<>();

        getReviews();

        // Set up RecyclerView
        reviewRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        reviewAdapter = new ReviewAdapter(reviewList);
        reviewRecyclerView.setAdapter(reviewAdapter);

        Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Generate a unique key for the review
                DatabaseReference reviewsRef = FirebaseDatabase.getInstance().getReference().child("review");
                DatabaseReference newReviewRef = reviewsRef.push();

                FirebaseUser user = mAuth.getCurrentUser();

                // Create a Review object
                assert user != null;
                Review review = new Review(user.getEmail(), reviewEditText.getText().toString());

                // Set the value of the review under the generated key
                newReviewRef.setValue(review);

                Toast.makeText(ReviewActivity.this, "Successfully added review to firebase", Toast.LENGTH_LONG).show();
                reviewList.add(review);

                reviewEditText.setText("");
            }
        });


        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getReviews();
                reviewAdapter.notifyDataSetChanged();
            }
        });
    }

    private void getReviews() {
        DatabaseReference reviewsRef = FirebaseDatabase.getInstance().getReference().child("review");
        reviewsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                reviewList.clear(); // Clear the list to avoid duplicates
                for (DataSnapshot reviewSnapshot : dataSnapshot.getChildren()) {
                    // Deserialize each Review object from the DataSnapshot
                    Review review = reviewSnapshot.getValue(Review.class);

                    if (review != null) {
                        // Add the review to the ArrayList
                        reviewList.add(review);
                    }
                }
                reviewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle any errors that occur during the read operation
                Toast.makeText(ReviewActivity.this, "Something went wrong getting reviews", Toast.LENGTH_LONG).show();
            }
        });
    }
}
