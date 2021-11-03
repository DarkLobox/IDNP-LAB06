package com.example.idnp_lab06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class CalendarioActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
        et1 = (EditText)findViewById(R.id.inputRuta);
        et2 = (EditText)findViewById(R.id.inputHora);
        Spinner spinner = findViewById(R.id.spDia);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.dias, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        et1.setText(preferences.getString("ruta", ""));
        et2.setText(preferences.getString("hora", ""));
    }


    public void Guardar(View view){
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = preferencias.edit();
        Obj_editor.putString("ruta", et1.getText().toString());
        Obj_editor.putString("hora", et2.getText().toString());

        Obj_editor.commit();
        finish();
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}