package com.example.seguridadsocialmanual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import Models.Model_eng;
import Models.Model_es;

public class PrimeraVentana extends AppCompatActivity implements Serializable {
    Model_es model_es;
    Model_eng model_eng;
    ListView lv;
    static String lenguage;

    private ArrayList<String> arrayParaListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_ventana);
        model_es = new Model_es();
        model_eng=new Model_eng();
        lv = (ListView) findViewById(R.id.view_listView);
        listindex();
        //añadir aqui los pasos en si de la base de datos
    }

    public void listindex(){
        try {
            arrayParaListView.clear();
            //lv.setAdapter(null);
        }
        catch (Exception e){}

        switch (lenguage){
            case "ESP":
                arrayParaListView = this.model_es.getListVSpanish();
                break;
            case "ENG":
                arrayParaListView = this.model_eng.getListVEnglish();
                break;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayParaListView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //añadir aqui el evento al pulsar los pasos
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    //Toast.makeText(PrimeraVentana.this, "Has pulsado " + arrayParaListView.get(position), Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(PrimeraVentana.this, CambiarIdioma.class);
                    //intent.putExtra("PrimeraVentana", PrimeraVentana.this);
                    startActivity(intent);
                }
            }
        });
    }
}