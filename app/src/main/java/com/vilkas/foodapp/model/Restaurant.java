package com.vilkas.foodapp.model;

public class Restaurant {

    private String name;
    private String country;
    private String city;
    private String address;
    private float rating;


    public Restaurant(String name, String country, String city, String address) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.address = address;
    }

    public Restaurant(String name, String country, String city, String address, float rating) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.address = address;
        this.rating = rating;
    }

    public Restaurant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
