package com.example.manillasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText cantidad;
    private TextView resultado;
    private Spinner material, dije, tipo, moneda;
    private String materiales [];
    private String dijes [];
    private String tipos [];
    private String monedas [];
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Captura de objetos utilizados
        cantidad = findViewById(R.id.txtCantidad);
        resultado = findViewById(R.id.txtResultado);
        material = findViewById(R.id.cmbMaterial);
        dije = findViewById(R.id.cmbDije);
        tipo = findViewById(R.id.cmbTipo);
        moneda = findViewById(R.id.cmbMoneda);

        //Se traen los arrays de strings
        materiales = getResources().getStringArray(R.array.material);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, materiales);
        material.setAdapter(adapter);

        dijes = getResources().getStringArray(R.array.dije);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dijes);
        dije.setAdapter(adapter);

        tipos = getResources().getStringArray(R.array.tipo);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tipos);
        tipo.setAdapter(adapter);

        monedas = getResources().getStringArray(R.array.moneda);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, monedas);
        moneda.setAdapter(adapter);
    }
}