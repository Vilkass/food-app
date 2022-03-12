package com.vilkas.foodapp.model;

import java.util.List;

public class Restaurant {

    private String name;
    private String country;
    private String city;
    private String address;
    private float rating;
    private List<Dish> dishes;


    public Restaurant(String name, String country, String city, String address, List<Dish> dishes) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.address = address;
        this.dishes = dishes;
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

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
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
