package com.example.seguridadsocialmanual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import Server.Connection;
import Server.SendMessage;
import conexionSQLite.SQLiteTabla;
import conexionSQLite.Utilidades;

public class MainActivity extends AppCompatActivity {

    EditText usuario;
    EditText contrasena;
    Button botonLogin;
    static Connection serverConnection;
    public static Boolean logedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serverConnection = new Connection("192.168.1.68", 5013);
        serverConnection.start();

        usuario = (EditText) findViewById(R.id.view_usuario);
        contrasena = (EditText) findViewById(R.id.view_contrasena);
        botonLogin = (Button)findViewById(R.id.view_botonLogin);

        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(usuario.getText().toString());
                System.out.println(contrasena.getText().toString());
                serverConnection.sendMessage(usuario.getText().toString(), contrasena.getText().toString());
                if(logedIn){
                    startActivity(new Intent(MainActivity.this, Menu.class));
                }
            }
        });
    }
}