package com.example.seguridadsocialmanual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Models.Menu.Menu_Model_eng;
import Models.Menu.Menu_Model_es;

public class Menu extends AppCompatActivity {

    static Button manualButton, demoButton, aboutButton;
    static Menu_Model_es model_es;
    static Menu_Model_eng model_eng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        model_es = new Menu_Model_es();
        model_eng = new Menu_Model_eng();

        manualButton = (Button) findViewById(R.id.main_manualButton);
        demoButton = (Button) findViewById(R.id.main_demoButton);
        aboutButton = (Button) findViewById(R.id.main_aboutButton);

        setButtonsText();
        setListeners();
    }

    public static void setButtonsText(){
        String[] values;
        switch (FirstWindow.language){
            case "ESP":
                values = model_es.getBtnsText();
                break;
            case "ENG":
                values = model_eng.getBtnsText();
                break;
            default:
                values = new String[3];
                break;
        }
        manualButton.setTextKeepState(values[0]);
        demoButton.setText(values[1]);
        aboutButton.setText(values[2]);
    }

    public void setListeners(){
        manualButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, FirstWindow.class));
            }
        });
        demoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, DemoMenu.class));
            }
        });
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, About.class));
            }
        });
    }

}