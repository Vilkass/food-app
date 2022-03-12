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

public class IngredientsListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    //private List<Ingredient> list;

    private String[] ingredients = {"Potato", "Sour Cream", "Pot", "Sour"};
    private boolean[] alergens = {false, false, true, false};

    public IngredientsListAdapter(DishActivity context, String[] names){
        super(context, R.layout.ingredient_list, names);

        this.context = context;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.ingredient_list, null,true);

        TextView ingredient = (TextView)rowView.findViewById(R.id.ingredient);
        TextView alergen = (TextView)rowView.findViewById(R.id.alergen);

        if(alergens[position]){
            alergen.setVisibility(View.VISIBLE);
        }
        ingredient.setText(ingredients[position]);

        return rowView;
    };



}
