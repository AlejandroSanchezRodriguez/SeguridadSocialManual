package com.example.seguridadsocialmanual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button botonManual;
    Button botonDemo;
    Button botonAD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        botonManual = (Button) findViewById(R.id.main_botonManual);
        botonDemo = (Button) findViewById(R.id.main_botonDemo);
        botonAD = (Button) findViewById(R.id.main_botonAD);

        botonManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, PrimeraVentana.class));
            }
        });
        botonDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        botonAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, AcercaDe.class));
            }
        });

    }
}