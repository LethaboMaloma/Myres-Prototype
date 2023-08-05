package com.example.myres;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ReviewDao {
    @Insert
    void insert(Review review);

    @Query("SELECT * FROM reviews WHERE houseTitle = :houseTitle")
    List<Review> getReviewsForHouse(String houseTitle);
}

