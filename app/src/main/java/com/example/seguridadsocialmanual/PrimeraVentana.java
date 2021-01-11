package com.example.seguridadsocialmanual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PrimeraVentana extends AppCompatActivity {

    private ArrayList<String> arrayParaListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_ventana);
        ListView lv = (ListView) findViewById(R.id.view_listView);

        //añadir aqui los pasos en si de la base de datos
        arrayParaListView = new ArrayList<String>();
        arrayParaListView.add("Cambiar idioma");
        arrayParaListView.add("Paso 1. Log-in");
        arrayParaListView.add("Paso 2");
        arrayParaListView.add("Paso 3");
        arrayParaListView.add("Paso 4");
        arrayParaListView.add("Paso 5");
        arrayParaListView.add("Paso 6");
        arrayParaListView.add("Paso 7");
        arrayParaListView.add("Paso 8");
        arrayParaListView.add("Paso 9");
        arrayParaListView.add("Paso 10");
        arrayParaListView.add("Paso 11");
        arrayParaListView.add("Paso 12");
        arrayParaListView.add("Paso 13");
        arrayParaListView.add("Paso 14");
        arrayParaListView.add("Paso 15");




        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayParaListView);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            //añadir aqui el evento al pulsar los pasos
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (arrayParaListView.get(position).toString() == "Cambiar idioma") {
                    //Toast.makeText(PrimeraVentana.this, "Has pulsado " + arrayParaListView.get(position), Toast.LENGTH_LONG).show();
                    startActivity(new Intent(PrimeraVentana.this, CambiarIdioma.class));

                }
            }
        });
    }
}