package com.example.manillasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

    public void cotizar(View v){
        double precio = 0;
        int mon, mat, dij, tip, cant = 1, dolar = 3200;

        if(validar()){
            cant = Integer.parseInt(cantidad.getText().toString());
            mon = moneda.getSelectedItemPosition();
            mat = material.getSelectedItemPosition();
            dij = dije.getSelectedItemPosition();
            tip = tipo.getSelectedItemPosition();

            switch (mon){
                case 0:
                    if(mat == 0 && dij == 0 && (tip == 0 || tip == 1)){
                        precio = 100 * cant;
                    }else if(mat == 0 && dij == 0 && tip == 2){
                        precio = 80 * cant;
                    }else if (mat == 0 && dij == 0 && tip == 3){
                        precio = 70 * cant;
                    }else if (mat == 0 && dij == 1 && (tip == 0 || tip == 1)){
                        precio = 120 * cant;
                    }else if (mat == 0 && dij == 1 && tip == 2){
                        precio = 100 * cant;
                    }else if (mat == 0 && dij == 1 && tip == 3){
                        precio = 90 * cant;
                    }else if(mat == 1 && dij == 0 && (tip == 0 || tip == 1)){
                        precio = 90 * cant;
                    }else if(mat == 1 && dij == 0 && tip == 2){
                        precio = 70 * cant;
                    }else if (mat == 1 && dij == 0 && tip == 3){
                        precio = 50 * cant;
                    }else if (mat == 1 && dij == 1 && (tip == 0 || tip == 1)){
                        precio = 110 * cant;
                    }else if (mat == 1 && dij == 1 && tip == 2){
                        precio = 90 * cant;
                    }else if (mat == 1 && dij == 1 && tip == 3){
                        precio = 80 * cant;
                    }
                    break;
                case 1:
                    if(mat == 0 && dij == 0 && (tip == 0 || tip == 1)){
                        precio = (100 * dolar) * cant;
                    }else if(mat == 0 && dij == 0 && tip == 2){
                        precio = (80 * dolar) * cant;
                    }else if (mat == 0 && dij == 0 && tip == 3){
                        precio = (70 * dolar) * cant;
                    }else if (mat == 0 && dij == 1 && (tip == 0 || tip == 1)){
                        precio = (120 * dolar) * cant;
                    }else if (mat == 0 && dij == 1 && tip == 2){
                        precio = (100 * dolar) * cant;
                    }else if (mat == 0 && dij == 1 && tip == 3){
                        precio = (90 * dolar) * cant;
                    }else if(mat == 1 && dij == 0 && (tip == 0 || tip == 1)){
                        precio = (90 * dolar) * cant;
                    }else if(mat == 1 && dij == 0 && tip == 2){
                        precio = (70 * dolar) * cant;
                    }else if (mat == 1 && dij == 0 && tip == 3){
                        precio = (50 * dolar) * cant;
                    }else if (mat == 1 && dij == 1 && (tip == 0 || tip == 1)){
                        precio = (110 * dolar) * cant;
                    }else if (mat == 1 && dij == 1 && tip == 2){
                        precio = (90 * dolar) * cant;
                    }else if (mat == 1 && dij == 1 && tip == 3){
                        precio = (80 * dolar) * cant;
                    }
                    break;
            }
            resultado.setText(String.valueOf(precio));
        }

    }

    public boolean validar(){
        if(cantidad.getText().toString().isEmpty()){
            cantidad.setError(getString(R.string.cantidad_manillas));
            cantidad.requestFocus();
            return false;
        }

        double cant = Double.parseDouble(cantidad.getText().toString());

        if(cant == 0) {
            cantidad.setError(getString(R.string.cantidad_manillas_cero));
            cantidad.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiar(View v){
        cantidad.setText("");
        resultado.setText("");
        cantidad.requestFocus();
        material.setSelection(0);
        dije.setSelection(0);
        tipo.setSelection(0);
        moneda.setSelection(0);
    }
}

