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

import Models.DataRequestResponse;
import Models.LoginRequest;
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
//
        usuario = (EditText) findViewById(R.id.view_usuario);
        contrasena = (EditText) findViewById(R.id.view_contrasena);
        botonLogin = (Button)findViewById(R.id.view_botonLogin);

        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DataRequestResponse message = new DataRequestResponse();
                message.setAction("0002");
                LoginRequest loginData = new LoginRequest(usuario.getText().toString(), contrasena.getText().toString());
                message.addData(loginData);
                serverConnection.sendMessage(message);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(logedIn){
                    startActivity(new Intent(MainActivity.this, Menu.class));
                }else{
                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void login(){
        startActivity(new Intent(MainActivity.this, Menu.class));
    }
}