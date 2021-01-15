package com.example.seguridadsocialmanual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import Models.Model_eng;
import Models.Model_es;
// Esta clase crea las variable de los objetos de la ventana emergente de cambiar idio,a
public class ChangeLanguaje extends AppCompatActivity {
    Model_es model_es;
    Model_eng model_eng;
    RadioGroup rg;
    RadioButton esp,eng;
    Button changeLanguage;
    FirstWindow primera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_languaje);

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

    //clase que le da evento a los radiobutton y boton de dicha ventana emergente
    public void eventButon(){
        changeLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = 2;
                if (esp.isChecked()){
                    if(FirstWindow.language.equals("ESP")){
                        result = 1;
                    }else{
                        FirstWindow.language = "ESP";
                    }
                }else if(eng.isChecked()){
                    if(FirstWindow.language.equals("ENG")){
                        result = 1;
                    }else{
                        FirstWindow.language = "ENG";
                    }
                }
                Intent intent=new Intent();
                setResult(result,intent);
                finish();
            }
        });
    }
}