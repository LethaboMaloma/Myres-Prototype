package com.example.myres;

public class Review {
    private String reviewText;
    private String user;

    public Review(){}

//    public Review(String reviewText) {
//        this.reviewText = reviewText;
//    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getUser() {
        return user;
    }

    public Review(String user, String reviewText) {
        this.reviewText = reviewText;
        this.user = user;
    }
}
