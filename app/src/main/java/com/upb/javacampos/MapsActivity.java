package com.upb.javacampos;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

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

        mMap = googleMap;
        final LatLng l0 = new LatLng(1.8516650, -76.0490729999);
        mMap.addMarker(new MarkerOptions().position(l0).title(""));
        final LatLng l1 = new LatLng(10.4455, -73.241);
        mMap.addMarker(new MarkerOptions().position(l1).title(""));
        final LatLng l2 = new LatLng(4.67731, -74.0951506);
        mMap.addMarker(new MarkerOptions().position(l2).title(""));
        final LatLng l3 = new LatLng(10.4605, -73.235);
        mMap.addMarker(new MarkerOptions().position(l3).title(""));
        final LatLng l4 = new LatLng(1.8516650,-76.0490729999);
        mMap.addMarker(new MarkerOptions().position(l4).title(""));
        final LatLng l5 = new LatLng(4.6257219,-74.1688982 );
        mMap.addMarker(new MarkerOptions().position(l5).title(""));
        final LatLng l6 = new LatLng(3.5832744,-76.4931093);
        mMap.addMarker(new MarkerOptions().position(l6).title(""));
        final LatLng l7 = new LatLng(4.4433724,-75.2402637);
        mMap.addMarker(new MarkerOptions().position(l7).title(""));
        final LatLng l8 = new LatLng(4.7443447,-74.117347);
        mMap.addMarker(new MarkerOptions().position(l8).title(""));
        final LatLng l9 = new LatLng(6.2742629,-75.57943900000001);
        mMap.addMarker(new MarkerOptions().position(l9).title(""));


    }

}