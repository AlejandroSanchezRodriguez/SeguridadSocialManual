package com.example.seguridadsocialmanual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Models.DataRequestResponse;
import Models.LoginRequest;
import Server.Connection;

//clase encargada de las conexiones, el login, y el splash
public class MainActivity extends AppCompatActivity {

    EditText user;
    EditText password;
    Button loginButton;
    static Connection serverConnection;
    public static Boolean logedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstWindow.language = "ESP";

        serverConnection = new Connection("192.168.1.67", 5013);
        serverConnection.start();

        user = (EditText) findViewById(R.id.view_usuario);
        password = (EditText) findViewById(R.id.view_contrasena);
        loginButton = (Button)findViewById(R.id.view_botonLogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DataRequestResponse message = new DataRequestResponse();
                message.setAction("0002");
                LoginRequest loginData = new LoginRequest(user.getText().toString(), password.getText().toString());
                message.addData(loginData);
                if(serverConnection.conected){
                    serverConnection.sendMessage(message);
                }else{
                    Toast.makeText(MainActivity.this, "Error de conexión con servidor", Toast.LENGTH_SHORT).show();
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(logedIn){
                    startActivity(new Intent(MainActivity.this, Menu.class));
                }else if(serverConnection.conected){
                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void login(){
        startActivity(new Intent(MainActivity.this, Menu.class));
    }
}