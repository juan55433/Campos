package com.upb.javacampos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

    }
    public void abrirRegistro(View v){
        //Ejecutado en el registro.
        Intent open = new Intent(this, Registro.class);
        startActivity(open);
    }
    public void abrir_inicioSesion(View v){
        //Ejecutado en iniciar sesión
        Intent open = new Intent(this, Login_Activity.class);
        startActivity(open);
    }

    public void AbrirMenu(View v) {
        Intent open = new Intent(this, MenuActivity.class);
        startActivity(open);
    }
}