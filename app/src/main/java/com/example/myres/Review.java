package com.example.myres;

public class Review {
    private String reviewText;

    public Review(){}

    public Review(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}
