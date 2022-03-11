package com.vilkas.foodapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.vilkas.foodapp.adapters.CommentListAdapter;

public class DishActivity extends AppCompatActivity {

    private ListView commentsList;

    // Animation
    private boolean descExpand = false, ingredientsExpand = false, restaurantsExpand = false;
    private ConstraintSet basicLayout = new ConstraintSet();
    private ConstraintSet fullDesc = new ConstraintSet();
    private ConstraintSet fullIngredients = new ConstraintSet();
    private ConstraintSet fullRestaurants = new ConstraintSet();
    private ConstraintLayout layout;

    private TextView showMore;
    private Button ingredientsBtn;
    private Button restaurantsBtn;


    // Test data
    String[] names = {"Tom Sailer", "Tom Thompson", "Alex Holiday"};
    String[] dates = {"2021-11-15", "2021-11-15", "2021-10-15"};
    String[] comments = {"This is my favourite dish! I love it and recommend you.", "Great Lithuanian dish! This dish is very soft and tasty!", ""};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish);


        CommentListAdapter adapter = new CommentListAdapter(this, names, dates, comments);
        commentsList = (ListView)findViewById(R.id.commentsList);
        commentsList.setAdapter(adapter);

        layout = (ConstraintLayout)findViewById(R.id.dishLayout);
        showMore = (TextView)findViewById(R.id.showMore);
        ingredientsBtn = (Button)findViewById(R.id.ingredientsBtn);
        restaurantsBtn = (Button)findViewById(R.id.restaurantsBtn);
        animate();


    }


    private void animate(){

        basicLayout.clone(layout);
        fullDesc.clone(this, R.layout.activity_dish_desc_expanded);
        fullIngredients.clone(this, R.layout.activity_dish_ingredients_expanded);
        fullRestaurants.clone(this, R.layout.activity_dish_restaurants_expanded);

    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void resizeDesc(View view) {
        TransitionManager.beginDelayedTransition(layout);
        if(descExpand){
            fullDesc.applyTo(layout);
            showMore.setText("Show less");
        }else {
            basicLayout.applyTo(layout);
            showMore.setText("Show more");
        }
        descExpand = !descExpand;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void resizeIngredients(View view) {
        TransitionManager.beginDelayedTransition(layout);
        if(ingredientsExpand){
            fullIngredients.applyTo(layout);
            ingredientsBtn.setBackgroundResource(R.drawable.ic_expand_less);
        }else {
            basicLayout.applyTo(layout);
            ingredientsBtn.setBackgroundResource(R.drawable.ic_sharp_expand_more_24);
        }
        ingredientsExpand = !ingredientsExpand;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void resizeRestaurants(View view) {
        TransitionManager.beginDelayedTransition(layout);
        if(restaurantsExpand){
            fullRestaurants.applyTo(layout);
            restaurantsBtn.setBackgroundResource(R.drawable.ic_expand_less);
        }else {
            basicLayout.applyTo(layout);
            restaurantsBtn.setBackgroundResource(R.drawable.ic_sharp_expand_more_24);
        }

        restaurantsExpand = !restaurantsExpand;
    }



}