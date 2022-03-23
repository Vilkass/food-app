package com.vilkas.foodapp;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.vilkas.foodapp.utils.StaticData;

import java.util.HashMap;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    public void filter(View view){
        startActivity(new Intent(getApplicationContext(), FilterActivity.class));
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng mark = null;
        HashMap<String, String> location = StaticData.getLocation();
        for(String food : StaticData.getFoods()){
            String[] cord = location.get(food).split(" ");
            mark = new LatLng(Double.valueOf(cord[0]), Double.valueOf(cord[1]));
            googleMap.addMarker(new MarkerOptions().position(mark).title(food));
        }

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(mark));

        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                // on marker click we are getting the title of our marker
                // which is clicked and displaying it in a toast message.
//                String markerName = marker.getTitle();
//                Toast.makeText(MapsActivity.this, "Clicked dish is " + markerName, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), DishActivity.class);
                intent.putExtra("dishName", marker.getTitle());


                startActivity(intent);

                return false;
            }
        });
    }
}