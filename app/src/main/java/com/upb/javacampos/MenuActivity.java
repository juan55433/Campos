package com.upb.javacampos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.upb.javacampos.R;
import com.upb.javacampos.Registro;
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
    public void VerRiesgo(View v){
        Toast.makeText(getApplicationContext(), "Usted no tiene riesgo al acercarse a un " +
                "campo electromagnético", Toast.LENGTH_LONG).show(); //Si la peticion sale bien
    }
    public void PedirCita(View v){
        Toast.makeText(getApplicationContext(), "Los datos de su cita fueron enviadas" +
                " a su correo de registro.", Toast.LENGTH_LONG).show(); //Si la peticion sale bien
    }
}