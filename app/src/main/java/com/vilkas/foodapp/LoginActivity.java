package com.vilkas.foodapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.vilkas.foodapp.database.SQLiteHelper;

public class LoginActivity extends AppCompatActivity {

    private EditText email, pass;
    private SQLiteHelper db;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initFields();
        db = new SQLiteHelper(getApplicationContext());

    }


    public void login(View view){

        if(validateFields()){
            Cursor data = db.getAllUsers();
            while (data.moveToNext()){
                if(email.getText().toString().equals(data.getString(1)) && pass.getText().toString().equals(data.getString(4))){
                    showMessage("Success", "Logged in!");
                    mapWindow();
                    return;
                }
            }
            showMessage("Error!", "Wrong email/password!");
        }else{
            showMessage("Error!", "Please fill all the fields!");
        }

    }

    private void initFields(){
        email = (EditText)findViewById(R.id.loginEmail);
        pass = (EditText)findViewById(R.id.loginPass);
    }

    private boolean validateFields(){
        if(email.getText().toString().isEmpty() || pass.getText().toString().isEmpty()){
            return false;
        }
        return true;
    }

    private void showMessage(String title, String message){

        new AlertDialog.Builder(LoginActivity.this).setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }


    private void mapWindow(){
        preferences = getSharedPreferences("guest", MODE_PRIVATE);
        preferences.edit().putBoolean("guest_mode", false).commit();


        startActivity(new Intent(getApplicationContext(), MapsActivity.class));
    }

}