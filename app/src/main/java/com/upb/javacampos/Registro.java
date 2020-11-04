package com.upb.javacampos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {
    EditText TC_Nombre,TC_Correo, TC_Fecha, TC_Antecedentes,TC_Numero, TC_Contrasena;
    Button B_Registro;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().hide();
        TC_Nombre = (EditText)findViewById(R.id.TC_Nombre);
        TC_Correo = (EditText)findViewById(R.id.TC_Correo);
        TC_Fecha = (EditText)findViewById(R.id.TC_Fecha);
        TC_Antecedentes = (EditText)findViewById(R.id.TC_Antecedentes);
        TC_Numero = (EditText)findViewById(R.id.TC_Numero);
        TC_Contrasena = (EditText)findViewById(R.id.TC_Contrasena);
        B_Registro = (Button)findViewById(R.id.B_Registro);

        B_Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ejecutarServicio("http://192.168.1.9/login/registro.php");

            }
        });
    }
    private void ejecutarServicio(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() { //Petición a la q se hará la llamada al servicio
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Operacion exitosa", Toast.LENGTH_LONG).show(); //Si la peticion sale bien
                Intent intent = new Intent(getApplicationContext(),Login_Activity.class);
                startActivity(intent);
            }

            //en caso de que la petición salió mal
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
            }
        }){
            //Datos que se envían a la BD

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                //enviar los parametros a la bd
                parametros.put("Nombre", TC_Nombre.getText().toString());
                parametros.put("usuario", TC_Correo.getText().toString());
                parametros.put("password", TC_Contrasena.getText().toString());
                parametros.put("Fecha_de_Nacimiento", TC_Fecha.getText().toString());
                parametros.put("Antecedentes", TC_Antecedentes.getText().toString());
                parametros.put("Numero_de_Telefono", TC_Numero.getText().toString());
                return parametros;
            }
        };

        //procesar la peticiones hechas por la app
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}