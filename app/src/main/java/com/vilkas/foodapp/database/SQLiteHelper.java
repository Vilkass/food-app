package com.vilkas.foodapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.vilkas.foodapp.model.RegisteredUser;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "FoodApp.db";

    private static final String USER_TABLE = "User";
    private static final String COLUMN_ID = "ID";
    private static final String USER_COLUMN_2 = "EMAIL";
    private static final String COLUMN_NAME = "NAME";
    private static final String USER_COLUMN_4 = "LAST_NAME";
    private static final String USER_COLUMN_5 = "PASS";
    private static final String USER_COLUMN_6 = "REGISTERED_DATE";
    private static final String COLUMN_DESC = "DESC";
    private static final String COLUMN_COUNTRY = "COUNTRY";


    private static final String DISH_TABLE = "Dish";
    private static final String DISH_COLUMN_4 = "CALORIES";


    private static final String INGREDIENT_TABLE = "Ingredient";
    private static final String INGREDIENT_COLUMN_2 = "TYPE";
    private static final String INGREDIENT_COLUMN_3 = "ALLERGEN";


    private static final String RESTAURANT_TABLE = "Restaurant";
    private static final String RESTAURANT_COLUMN_4 = "CITY";
    private static final String RESTAURANT_COLUMN_5 = "ADDRESS";
    private static final String COLUMN_RATING = "RATING";

    private static final String REVIEW_TABLE = "Review";
    private static final String REVIEW_COLUMN_3 = "COMMENT";
    private static final String REVIEW_COLUMN_4 = "DATE";
    private static final String REVIEW_COLUMN_5 = "USER";

    private static final String COUNTRY_TABLE = "Country";


    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + USER_TABLE + " ("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+USER_COLUMN_2+" TEXT, "+COLUMN_NAME+" TEXT, "+USER_COLUMN_4+" TEXT, "+USER_COLUMN_5+" TEXT, "+USER_COLUMN_6+" DATE, "+COLUMN_DESC+" TEXT, "+COLUMN_COUNTRY+" TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + COUNTRY_TABLE + " ("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_NAME+" TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + DISH_TABLE + " ("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_NAME+" TEXT, " +COLUMN_DESC+ " TEXT," +DISH_COLUMN_4+ " DOUBLE, "+COLUMN_COUNTRY+" TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + INGREDIENT_TABLE + "( " + COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME +" TEXT, " + INGREDIENT_COLUMN_2 + " TEXT, " + INGREDIENT_COLUMN_3 + " BOOLEAN )");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + RESTAURANT_TABLE + "( " + COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME+" TEXT, " + COLUMN_COUNTRY + " TEXT, " +  RESTAURANT_COLUMN_4 + " TEXT, " + RESTAURANT_COLUMN_5 + " TEXT, " + COLUMN_RATING + " FLOAT )");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + REVIEW_TABLE + "( " + COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +  COLUMN_RATING + " INTEGER, " + REVIEW_COLUMN_3 + " TEXT, " + REVIEW_COLUMN_4 + " DATE, " + REVIEW_COLUMN_5 + " INTEGER )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + DISH_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + INGREDIENT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + RESTAURANT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + REVIEW_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + COUNTRY_TABLE);
        onCreate(db);
    }

    public void addUser(RegisteredUser user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_COLUMN_2, user.getEmail());
        contentValues.put(COLUMN_NAME, user.getName());
        contentValues.put(USER_COLUMN_4, user.getLastName());
        contentValues.put(USER_COLUMN_5, user.getPass());
        contentValues.put(USER_COLUMN_6, String.valueOf(user.getRegisteredDate()));
        contentValues.put(COLUMN_DESC, user.getDesc());
        contentValues.put(COLUMN_COUNTRY, user.getCountry());
        db.insert(USER_TABLE, null, contentValues);
    }

    public Cursor getAllUsers(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor allData = db.rawQuery("SELECT * FROM " + USER_TABLE, null);
        return allData;
    }


}
