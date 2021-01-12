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

import Models.Model_es;

public class PrimeraVentana extends AppCompatActivity {
    Model_es model_es=new Model_es();
    ListView lv;

    private ArrayList<String> arrayParaListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_ventana);
        lv = (ListView) findViewById(R.id.view_listView);
        listindex(model_es.getListVSpanish());
        //añadir aqui los pasos en si de la base de datos
    }
    public void listindex(ArrayList<String>textIndex){
        try {
            lv.setAdapter(null);
        }
        catch (Exception e){

        }

        arrayParaListView = new ArrayList<String>();
        for (int i=0;i<9;i++){
            arrayParaListView.add(textIndex.get(i));
        }
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