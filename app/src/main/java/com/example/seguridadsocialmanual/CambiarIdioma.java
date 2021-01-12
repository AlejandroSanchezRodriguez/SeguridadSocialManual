package com.example.seguridadsocialmanual;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.state.State;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import Models.Model_eng;
import Models.Model_es;

public class CambiarIdioma extends AppCompatActivity {
    Model_es model_es= new Model_es();
    Model_eng model_eng=new Model_eng();
    RadioGroup rg;
    RadioButton esp,eng;
    Button changeLanguage;
    PrimeraVentana primera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_idioma);

        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);

        int ancho = medidasVentana.widthPixels;
        int alto = medidasVentana.heightPixels;

        getWindow().setLayout((int) (800), (int)(1000));

        rg = (RadioGroup) findViewById(R.id.view_radioGroup);
        esp=findViewById(R.id.view_radioButtonEspanol);
        eng=findViewById(R.id.view_radioButtonIngles);
        changeLanguage=findViewById(R.id.view_botonCambiarIdioma);
        eventButon();


    }
    public void eventButon(){
        changeLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (esp.isSelected()){
                    primera.listindex(model_es.getListVSpanish());
                }else if(eng.isSelected()){
                    primera.listindex(model_eng.getListVEnglish());
                }
            }
        });
    }
}