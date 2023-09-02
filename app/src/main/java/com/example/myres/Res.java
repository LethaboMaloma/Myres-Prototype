package com.example.myres;

import java.util.ArrayList;
import java.util.HashMap;

public class Res {
    private String resName, resLocation, resDescription;
    private double resRating, monthlyRent;
    private int resDistance;

    public ArrayList<Integer> getResImages() {
        return resImages;
    }

    ArrayList<Integer> resImages;
    private ArrayList<Object> amenities;
    private ArrayList<Review> reviews;
    public static HashMap<String, Integer> amenityIcons = new HashMap<>();

    static {
        amenityIcons.put("mixed",R.drawable.mixed_icon);
        amenityIcons.put("girl", R.drawable.girls_only_ic);
        amenityIcons.put("boy", R.drawable.boys_only_ic);
        amenityIcons.put("wifi", R.drawable.wifi_icon);
        amenityIcons.put("road", R.drawable.road_ic);
        amenityIcons.put("power", R.drawable.power_icon);
        amenityIcons.put("dumbell", R.drawable.dumbell_ic);
        amenityIcons.put("car", R.drawable.car_ic);
        amenityIcons.put("water", R.drawable.water_icon);
        amenityIcons.put("computer", R.drawable.computer_ic);
    }

    public String getResName() {
        return resName;
    }

    public String getResLocation() {
        return resLocation;
    }

    public String getResDescription() {
        return resDescription;
    }

    public double getResRating() {
        return resRating;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public int getResDistance() {
        return resDistance;
    }

    public ArrayList<Object> getAmenities() {
        return amenities;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public static HashMap<String, Integer> getAmenityIcons() {
        return amenityIcons;
    }

    public Res(ArrayList<Integer> resImages, String resName, double resRating, String resLocation, String resDescription, double monthlyRent, int resDistance, ArrayList<Object> amenities, ArrayList<Review> reviews) {
        this.resImages = resImages;
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
