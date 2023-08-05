package com.example.myres;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "reviews")
public class Review {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String houseTitle;
    private String reviewText;

    public Review(String houseTitle, String reviewText) {
        this.houseTitle = houseTitle;
        this.reviewText = reviewText;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouseTitle() {
        return houseTitle;
    }

    public void setHouseTitle(String houseTitle) {
        this.houseTitle = houseTitle;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}
