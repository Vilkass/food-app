package com.vilkas.foodapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.vilkas.foodapp.database.SQLiteHelper;
import com.vilkas.foodapp.model.RegisteredUser;
import com.vilkas.foodapp.utils.PasswordValidator;

public class RegisterActivity extends AppCompatActivity {

    private EditText pass, pass2, firstName, lastName, email;

    private SQLiteHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initFields();
        db = new SQLiteHelper(getApplicationContext());

    }






    public void register(View view){
        String p = pass.getText().toString();
        if(validateFields()){
            if(pass.getText().toString().equals(pass2.getText().toString())){
                // Passwords match
                if(PasswordValidator.validate(p)){
                    // Password is valid
                    Cursor data = db.getAllUsers();
                    while (data.moveToNext()){
                        if(email.getText().toString().equals(data.getString(1))){
                            showMessage("Error!", "User with that email already exists");
                            return;
                        }
                    }
                    RegisteredUser user = new RegisteredUser(firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), p);
                    db.addUser(user);
                    showMessage("Success!", "User created successfully!");
                    clearFields();
                }else{
                    showMessage("Error!", "Password must be at least 7 char long, have a number and special character");
                }

            }else{
                showMessage("Error!", "Passwords do not match!");
            }
        }else{
            showMessage("Error!", "Please fill all the fields!");
        }



    }



    private void showMessage(String title, String message){

        new AlertDialog.Builder(RegisterActivity.this).setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }


    private void initFields(){
        pass = (EditText)findViewById(R.id.regPass);
        pass2 = (EditText)findViewById(R.id.regPass2);
        email = (EditText)findViewById(R.id.regEmail);
        firstName = (EditText)findViewById(R.id.regFirstName);
        lastName = (EditText)findViewById(R.id.regLastName);
    }

    private boolean validateFields(){
        if(!email.getText().toString().isEmpty() && !pass.getText().toString().isEmpty() && !pass2.getText().toString().isEmpty() && !firstName.getText().toString().isEmpty() && !lastName.getText().toString().isEmpty()){
            return true;
        }
        return false;
    }

    private void clearFields(){
        email.getText().clear();
        pass.getText().clear();
        pass2.getText().clear();
        firstName.getText().clear();
        lastName.getText().clear();
    }

}