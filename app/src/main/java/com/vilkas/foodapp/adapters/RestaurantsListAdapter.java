package com.vilkas.foodapp.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.vilkas.foodapp.DishActivity;
import com.vilkas.foodapp.R;

public class RestaurantsListAdapter extends ArrayAdapter<String> {

    private final Activity context;


    private String[] restaurants = {"PepCo", "PepCo"};
    private Float[] ratings = {4.6f, 4.6f};

    public RestaurantsListAdapter(DishActivity context, String[] names){

        super(context, R.layout.restaurant_list, names);
        this.context = context;
        this.restaurants = names;

    }


    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.restaurant_list, null,true);

        TextView restaurant = (TextView)rowView.findViewById(R.id.restaurant);
        //ImageView restaurantImage = (ImageView)rowView.findViewById(R.id.restaurantIcon);
        TextView restaurantRating = (TextView)rowView.findViewById(R.id.restaurantRating);
        RatingBar restaurantRatingBar = (RatingBar)rowView.findViewById(R.id.restaurantRatingBar);

        restaurant.setText(restaurants[position]);
        restaurantRating.setText(String.valueOf(ratings[position]));
        restaurantRatingBar.setRating(ratings[position]);

        return rowView;
    };


}
