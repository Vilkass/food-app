package com.vilkas.foodapp.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.Rating;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.vilkas.foodapp.DishActivity;
import com.vilkas.foodapp.R;

import java.util.List;

public class CommentListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] names;
    private final String[] dates;
    private final String[] comments;

    private final int[] ratings = {4, 5, 5};

    //private final List<Review> reviews;

    public CommentListAdapter(DishActivity context, String[] names, String[] dates, String[] comments) {

        super(context, R.layout.comment_list, names);

        this.context = context;
        this.names = names;
        this.dates = dates;
        this.comments = comments;

    }

    /*
    public CommentListAdapter(DishActivity context, List<Review> reviews) {

        super(context, R.layout.comment_list);

    }
     */


    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.comment_list, null,true);

        View divider = (View)rowView.findViewById(R.id.commentDivider);
        TextView name = (TextView) rowView.findViewById(R.id.commentName);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.commentIcon);
        TextView commentTime = (TextView) rowView.findViewById(R.id.commentTime);
        TextView comment = (TextView) rowView.findViewById(R.id.comment);
        RatingBar ratingBar = (RatingBar)rowView.findViewById(R.id.commentListRating);

        if(position == 0){
            divider.setVisibility(View.GONE);
            imageView.setBackgroundResource(R.drawable.avatar1);
        }if(position == 1){

            imageView.setBackgroundResource(R.drawable.avatar2);
        }if(position == 2){

            imageView.setBackgroundResource(R.drawable.avatar3);
        }


        ratingBar.setRating(ratings[position]);
        name.setText(names[position]);
        commentTime.setText(dates[position]);
        comment.setText(comments[position]);

        System.out.println(position);

        return rowView;

    };


}
