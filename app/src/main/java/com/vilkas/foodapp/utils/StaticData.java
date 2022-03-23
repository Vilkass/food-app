package com.vilkas.foodapp.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StaticData {

    private static List<String> foods = new ArrayList<>();
    private static HashMap<String, String> foodLocation = new HashMap<>();
    private static double[] location = {54.68916, 25.2798, 56.0352, 22.4497, 54.6372, 24.9339};


    public static List<String> getFoods(){
        foods.add("Cepelinai");
        foods.add("Vėdarai");
        foods.add("Kibinai");

        return foods;
    }

    public static HashMap<String, String> getLocation(){
        int i = 0;
        for(String food : getFoods()){
            String cord = location[i] + " " + location[++i];
            foodLocation.put(food, cord);
            i++;
        }
        return foodLocation;
    }



}
