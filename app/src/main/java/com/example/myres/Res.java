package com.example.myres;

import java.util.ArrayList;

public class Res {
    private String resName, resLocation, resDescription;
    private double resRating, monthlyRent;
    private int resDistance;

    private ArrayList<Integer> amenities;
    private ArrayList<Review> reviews;

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

    public double getResRating() {
        return resRating;
    }

    public void setResRating(double resRating) {
        this.resRating = resRating;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public int getResDistance() {
        return resDistance;
    }

    public void setResDistance(int resDistance) {
        this.resDistance = resDistance;
    }

    public ArrayList<Integer> getAmenities() {
        return amenities;
    }

    public void setAmenities(ArrayList<Integer> amenities) {
        this.amenities = amenities;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public Res(String resName, double resRating, String resLocation, String resDescription, double monthlyRent, int resDistance, ArrayList<Integer> amenities, ArrayList<Review> reviews) {
        this.resName = resName;
        this.resLocation = resLocation;
        this.resDescription = resDescription;
        this.resRating = resRating;
        this.monthlyRent = monthlyRent;
        this.resDistance = resDistance;
        this.amenities = amenities;
        this.reviews = reviews;
    }

}
