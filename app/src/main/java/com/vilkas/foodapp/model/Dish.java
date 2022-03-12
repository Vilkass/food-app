package com.vilkas.foodapp.model;

import java.util.List;

public class Dish {

    private String name;
    private String desc;
    private double calories;
    private List<Ingredient> ingredients;
    private List<Review> reviews;
    private String country;

    public Dish(String name, String desc, List<Ingredient> ingredients, List<Review> reviews, String country) {
        this.name = name;
        this.desc = desc;
        this.ingredients = ingredients;
        this.reviews = reviews;
        this.country = country;
    }

    public Dish(String name, String desc, double calories, List<Ingredient> ingredients, List<Review> reviews, String country) {
        this.name = name;
        this.desc = desc;
        this.calories = calories;
        this.ingredients = ingredients;
        this.reviews = reviews;
        this.country = country;
    }

    public Dish() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
