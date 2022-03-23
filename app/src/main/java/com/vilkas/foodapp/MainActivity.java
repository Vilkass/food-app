package com.vilkas.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.vilkas.foodapp.database.SQLiteHelper;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private SQLiteHelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creates local sql lite database
        initDatabase();

    }

    // Opens log in window
    public void logInWindow(View view){
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }

    // Opens register window
    public void registerWindow(View view){
        startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
    }

    // User continues as guest
    public void guestWindow(View view){
        preferences = getSharedPreferences("guest", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("guest_mode", true);
        editor.commit();
        startActivity(new Intent(getApplicationContext(), MapsActivity.class)); // SearchActivity.class
    }


    private void initDatabase(){
        preferences = getSharedPreferences("first_time", MODE_PRIVATE);
        if(preferences.getBoolean("init_db", true) || true){
            db = new SQLiteHelper(getApplicationContext());
            preferences.edit().putBoolean("init_db", false).commit();
            Toast.makeText(MainActivity.this, "DB created!", Toast.LENGTH_SHORT).show();
        }
    }

}