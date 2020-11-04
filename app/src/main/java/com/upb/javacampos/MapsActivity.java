package com.upb.javacampos;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        BufferedReader br = null;
        String linea = "";
        String csvSplit = ",";
        try {
            br = new BufferedReader(new FileReader("D:\\Descargas\\Proyecto-000340107-(parcial 2)\\Registro_de_mediciones_de_campos_electromagn_ticos_-_RNI_Todas_Las_Ciudades.csv"));

            System.out.println("prueba");
            int i = 0;
            while ((linea = br.readLine()) != null) {
                if(i > 0){

                    String a = "";
                    String[] csv = linea.split(csvSplit);
                    String aux = "";
                    a = csv[6];
                    int contador = 0;
                    for(int j = 1; j < csv[6].length();j++){
                        if(csv[6].charAt(j) == 32){
                            break;
                        }
                        contador++;
                    }
                    LatLng punto = new LatLng(Double.parseDouble(a.substring(0,contador)),
                            Double.parseDouble(a.substring(contador+1, a.length())));
                    mMap.addMarker(new MarkerOptions().position(punto).title(csv[1]));
                    i++;
                }else i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

//        mMap.moveCamera(CameraUpdateFactory.newLatLng(puntos[0]));
    }
}