package com.example.idnp_lab06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RutasActivity extends AppCompatActivity {
    String llave = "coordenadas";
    TextView co;
    EditText la,lo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutas);
        co = findViewById(R.id.coordenadasGuardadas);
        la = findViewById(R.id.inputLatitudRuta);
        lo = findViewById(R.id.inputLongitudRuta);

        SharedPreferences preferences = getSharedPreferences("ruta",Context.MODE_PRIVATE);
        co.setText(preferences.getString(llave,""));
    }

    public void BorrarRuta(View view){
        SharedPreferences preferences = getSharedPreferences("ruta",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(llave,"");
        editor.apply();
        la.setText("");
        lo.setText("");
        co.setText("");
    }

    public void GuardarRuta(View view){
        SharedPreferences preferences = getSharedPreferences("ruta",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        String coordenada = la.getText().toString()+","+lo.getText().toString();
        String valorActual = preferences.getString(llave,"") + "\n" +coordenada;
        editor.putString(llave,valorActual);
        editor.apply();

        la.setText("");
        lo.setText("");
        co.setText(valorActual);
    }

}
