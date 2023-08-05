package com.example.myres;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Review.class}, version = 1)
public abstract class ReviewDatabase extends RoomDatabase {
    public abstract ReviewDao reviewDao();
}

