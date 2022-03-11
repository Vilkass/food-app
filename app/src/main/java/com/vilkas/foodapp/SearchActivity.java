package com.vilkas.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

public class SearchActivity extends AppCompatActivity {

    private SearchView searchView;
    private ListView listView;
    private Button searchFilter;
    private Button searchMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        init();
        testList();

    }

    private void init(){
        searchView = (SearchView)findViewById(R.id.searchView);
        listView = (ListView)findViewById(R.id.listView);
        searchMap = (Button)findViewById(R.id.searchMap);
        searchFilter = (Button)findViewById(R.id.searchFilter);

        listView.setVisibility(View.INVISIBLE);
    }


    private void testList(){

        String[] names = {"Cepelinai", "Kebabai", "Troskinys", "Vedarai", "Makaronai"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        listView.setAdapter(adapter);
        searchView.onActionViewExpanded();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextSubmit(String s){
                return false;
            }


            @Override
            public boolean onQueryTextChange(String s){
                listView.setVisibility(View.VISIBLE);
                searchMap.setVisibility(View.INVISIBLE);
                searchFilter.setVisibility(View.INVISIBLE);

                if(s.length() > 2){
                    adapter.getFilter().filter(s);
                }else{
                    adapter.clear();
                }

                return false;
            }

        });

    }

    public void mapWindow(View view){
        startActivity(new Intent(getApplicationContext(), MapActivity.class));
    }



}