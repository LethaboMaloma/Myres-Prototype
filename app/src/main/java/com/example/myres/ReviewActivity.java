package com.example.myres;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myres.Review;
import com.example.myres.ReviewAdapter;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ReviewActivity extends AppCompatActivity {
    private static final String COLLECTION_REVIEWS = "reviews";

    private TextView houseTitleTextView;
    private EditText reviewEditText;
    private RecyclerView reviewRecyclerView;
    private List<Review> reviewList = new ArrayList<>();
    private ReviewAdapter reviewAdapter;
    private FirebaseFirestore firestore;
    private CollectionReference reviewsCollection;
    private String houseTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        houseTitleTextView = findViewById(R.id.house_title_textview);
        reviewEditText = findViewById(R.id.review_edittext);
        reviewRecyclerView = findViewById(R.id.review_recycler_view);

        houseTitle = getIntent().getStringExtra("house_title");
        houseTitleTextView.setText(houseTitle);

        // Set up RecyclerView
        reviewRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        reviewAdapter = new ReviewAdapter(reviewList);
        reviewRecyclerView.setAdapter(reviewAdapter);

        // Initialize Firestore
        firestore = FirebaseFirestore.getInstance();
        reviewsCollection = firestore.collection(COLLECTION_REVIEWS);

        // Load existing reviews from Firestore
        loadReviews();

        Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get review text from EditText
                String reviewText = reviewEditText.getText().toString().trim();

                // Create a new review object
                Review review = new Review(houseTitle, reviewText);

                // Save the review to Firestore
                saveReview(review);

                // Clear the review EditText
                reviewEditText.setText("");
            }
        });

        Button resetButton = findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear the reviews list and notify the adapter
                reviewList.clear();
                reviewAdapter.notifyDataSetChanged();

                // Delete all reviews for this house from Firestore
                deleteReviewsForHouse(houseTitle);
            }
        });
    }

    private void loadReviews() {
        reviewsCollection.whereEqualTo("houseTitle", houseTitle)
                .addSnapshotListener((querySnapshot, e) -> {
                    if (e != null) {
                        // Handle error
                        return;
                    }

                    for (DocumentChange documentChange : querySnapshot.getDocumentChanges()) {
                        switch (documentChange.getType()) {
                            case ADDED:
                                QueryDocumentSnapshot document = documentChange.getDocument();
                                Review review = document.toObject(Review.class);
                                reviewList.add(review);
                                break;
                            case MODIFIED:
                                // Handle modified documents if needed
                                break;
                            case REMOVED:
                                // Handle removed documents if needed
                                break;
                        }
                    }

                    reviewAdapter.notifyDataSetChanged();
                });
    }

    private void saveReview(Review review) {
        reviewsCollection.add(review)
                .addOnSuccessListener(documentReference -> {
                    // Review saved successfully
                })
                .addOnFailureListener(e -> {
                    // Handle error
                });
    }

    private void deleteReviewsForHouse(String houseTitle) {
        reviewsCollection.whereEqualTo("houseTitle", houseTitle)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            document.getReference().delete();
                        }
                    } else {
                        // Handle error
                    }
                });
    }
}
