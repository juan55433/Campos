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

public class Login_Activity extends AppCompatActivity {
    EditText EUsr, EPwd;
    Button BTLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        getSupportActionBar().hide();
        EUsr = findViewById(R.id.EUsr);
        EPwd = findViewById(R.id.EPwd);
        BTLogin = findViewById(R.id.BTLogin);
        BTLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                validarUsuario("http://192.168.1.9/login/validar_usuario.php");
            }
        });
    }
    private void validarUsuario(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>(){
            @Override
            public void onResponse(String response){
                if(!response.isEmpty()){

                    Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Login_Activity.this, "Usuario o contraseña incorrectos",  Toast.LENGTH_SHORT);
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Toast.makeText(Login_Activity.this, "Error",Toast.LENGTH_SHORT);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parameters = new HashMap<String,String>();
                parameters.put("usuario",EUsr.getText().toString());
                parameters.put("password",EPwd.getText().toString());

                return parameters;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}