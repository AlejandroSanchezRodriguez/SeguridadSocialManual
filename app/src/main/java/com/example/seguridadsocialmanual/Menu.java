package com.example.seguridadsocialmanual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button manualButton;
    Button demoButton;
    Button aboutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        manualButton = (Button) findViewById(R.id.main_manualButton);
        demoButton = (Button) findViewById(R.id.main_demoButton);
        aboutButton = (Button) findViewById(R.id.main_aboutButton);

        manualButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, FirstWindow.class));
            }
        });
        demoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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