package com.example.idnp_lab06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void guardarSesion(View view){
        Intent intent= new Intent (this, SesionActivity.class);
        startActivity(intent);
    }

    public void guardarRutas(View view){
        Intent intent= new Intent (this, RutasActivity.class);
        startActivity(intent);
    }

    public void guardarCalendario(View view){
        Intent intent= new Intent (this, CalendarioActivity.class);
        startActivity(intent);
    }

    public void guardarUbicacion(View view){
        Intent intent= new Intent (this, UbicacionActivity.class);
        startActivity(intent);
    }
}