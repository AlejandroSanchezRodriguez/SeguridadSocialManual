package com.example.seguridadsocialmanual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import Models.ContentRequest;
import Models.DataRequestResponse;
import Models.Model_eng;
import Models.Model_es;

public class FirstWindow extends AppCompatActivity{
    Model_es model_es;
    Model_eng model_eng;
    ListView lv;
    static String language;
    private ArrayList<String> arrayParaListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_window);
        model_es = new Model_es();
        model_eng=new Model_eng();
        lv = (ListView) findViewById(R.id.view_listView);
        listindex();
        setItemClickLv();
        //añadir aqui los pasos en si de la base de datos
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println(resultCode);
        if (resultCode == 2){
            listindex();
            setItemClickLv();
            Menu.setButtonsText();
            if(About.loaded)    About.setText();
            if(DemoMenu.loaded) DemoMenu.setText();
        }
    }

    public void listindex(){
        try {
            //arrayParaListView.clear();
            lv.setAdapter(null);
        }
        catch (Exception e){}



        switch (language){
            case "ESP":
                arrayParaListView = model_es.getListVSpanish();
                break;
            case "ENG":
                arrayParaListView = model_eng.getListVEnglish();
                break;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayParaListView);
        lv.setAdapter(adapter);
    }
    public void setItemClickLv(){
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    //si se pulsa el primer elemento se inicia la actividad de cambiar idioma
                    Intent intent = new Intent(FirstWindow.this, ChangeLanguaje.class);
                    startActivityForResult(intent, 2);
                }else{
                    //send a request to server to get the content of the specified page in the current language.
                    DataRequestResponse message = new DataRequestResponse();
                    message.setAction("0003");
                    ContentRequest contentRequest = new ContentRequest(position,language);
                    message.addData(contentRequest);
                    MainActivity.serverConnection.sendMessage(message);
                    Manual_Page.tittle = arrayParaListView.get(position).toString();
                    startActivity(new Intent(FirstWindow.this, Manual_Page.class));
                }
            }
        });
    }
}