package com.example.myres;

import java.util.ArrayList;

public class Res {
    private String resName, resLocation, resDescription;
    private int resRating;
    private int monthlyRent;

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    private int distance;
    private ArrayList<String> amenities;
    private ArrayList<Review> reviews;

    public Res(String resName, String resLocation, String resDescription, int resRating, int monthlyRent, int distance, ArrayList<String> amenities, ArrayList<Review> reviews) {
        this.resName = resName;
        this.resLocation = resLocation;
        this.resDescription = resDescription;
        this.resRating = resRating;
        this.monthlyRent = monthlyRent;
        this.distance = distance;
        this.amenities = amenities;
        this.reviews = reviews;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResLocation() {
        return resLocation;
    }

    public void setResLocation(String resLocation) {
        this.resLocation = resLocation;
    }

    public String getResDescription() {
        return resDescription;
    }

    public void setResDescription(String resDescription) {
        this.resDescription = resDescription;
    }

    public int getResRating() {
        return resRating;
    }

    public void setResRating(int resRating) {
        this.resRating = resRating;
    }

    public int getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(int monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public ArrayList<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(ArrayList<String> amenities) {
        this.amenities = amenities;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }
}
