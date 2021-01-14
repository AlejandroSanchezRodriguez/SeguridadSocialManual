package com.example.seguridadsocialmanual;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import Models.About_Page.AboutPage_Model_eng;
import Models.About_Page.AboutPage_Model_es;

public class About extends AppCompatActivity {

    static TextView tv1, tv2;
    static AboutPage_Model_es model_es;
    static AboutPage_Model_eng model_eng;
    public static boolean loaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        tv1 = findViewById(R.id.textView3);
        tv2 = findViewById(R.id.textView12);
        model_es = new AboutPage_Model_es();
        model_eng =  new AboutPage_Model_eng();

        loaded = true;
        setText();
    }

    public static void setText(){
        String[] values;
        switch (FirstWindow.language){
            case "ESP":
                values = model_es.getTexts();
                break;
            case "ENG":
                values = model_eng.getTexts();
                break;
            default:
                values = new String[3];
                break;
        }
        tv1.setText(values[0]);
        tv2.setText(values[1]);
    }
}