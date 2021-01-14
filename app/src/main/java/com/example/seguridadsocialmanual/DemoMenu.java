package com.example.seguridadsocialmanual;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import Models.Demo_Menu.Demo_Menu_Model_eng;
import Models.Demo_Menu.Demo_Menu_Model_es;

public class DemoMenu extends AppCompatActivity {

    private static Demo_Menu_Model_es model_es;
    private static Demo_Menu_Model_eng model_eng;
    private static Button btn1, btn2, btn3, btn4;
    public static boolean loaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_menu);

        btn1 = findViewById(R.id.loginDemo);
        btn2 = findViewById(R.id.ftpDemo);
        btn3 = findViewById(R.id.emailDemo);
        btn4 = findViewById(R.id.aboutDemo);

        model_es = new Demo_Menu_Model_es();
        model_eng = new Demo_Menu_Model_eng();

        loaded = true;
        setText();
    }

    public static void setText(){
        String[] values;
        switch (FirstWindow.language){
            case "ESP":
                values = model_es.getValues();
                break;
            case "ENG":
                values = model_eng.getValues();
                break;
            default:
                values = new String[4];
                break;
        }
        btn1.setText(values[0]);
        btn2.setText(values[1]);
        btn3.setText(values[2]);
        btn4.setText(values[3]);
    }
}