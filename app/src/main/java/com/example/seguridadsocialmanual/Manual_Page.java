package com.example.seguridadsocialmanual;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Manual_Page extends AppCompatActivity {

    public static String tittle, content;
    private TextView tvTittle,  tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual__page);

        tvTittle = findViewById(R.id.tittleTv);
        tvContent = findViewById(R.id.tvContent);

        tvTittle.setText(tittle);
        tvContent.setText(content);
    }
}