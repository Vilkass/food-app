package com.vilkas.foodapp.utils;

import com.vilkas.foodapp.model.Dish;
import com.vilkas.foodapp.model.Ingredient;
import com.vilkas.foodapp.model.RegisteredUser;
import com.vilkas.foodapp.model.Restaurant;
import com.vilkas.foodapp.model.Review;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InitMap {


    private static List<Review> reviews = new ArrayList<>();
    private static List<Ingredient> ingredients = new ArrayList<>();
    private static List<Dish> dishes = new ArrayList<>();
    private static List<Restaurant> restaurants = new ArrayList<>();


    private static void initRestaurants(){
        RegisteredUser user = new RegisteredUser("Tom", "Sailer", "", "");
        ingredients.add(new Ingredient("Potato", "Potato", false));
        ingredients.add(new Ingredient("Pork", "Meat", false));
        ingredients.add(new Ingredient("Salt", "Spice", false));
        reviews.add(new Review((short) 4, "This is my favourite dish! I love it and recommend you.", "2022-10-20", user));
        dishes.add(new Dish("Cepelinai", "Lorem ipsum dolor sit amet consectetur adipiscing elit, urna consequat felis vehicula class ultricies mollis dictumst, aenean non a in donec nulla. Phasellus ante pellentesque erat cum risus consequat imperdiet aliquam, integer placerat et turpis mi eros nec lobortis taciti, vehicula nisl litora tellus ligula porttitor metus.", ingredients, reviews, "Lithuania"));
        restaurants.add(new Restaurant("PepCo", "Lithuania", "Vilnius", "Centro g. 5", dishes));
    }


    public static List<Restaurant> getRestaurants(){
        initRestaurants();
        return restaurants;
    }

}
