package com.upb.javacampos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.upb.javacampos.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();

    }
    public void AbrirMapa(View v){
        Intent open = new Intent(this, MapsActivity.class);
        startActivity(open);

    }
}