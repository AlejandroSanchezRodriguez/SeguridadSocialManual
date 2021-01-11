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

    ArrayList <String> login;
    EditText usuario;
    EditText contrasena;
    Button botonLogin;
    static Connection serverConnection;
    public static Boolean logedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serverConnection = new Connection("192.168.1.67", 5013);
        serverConnection.start();

        login = new ArrayList<>();
        login.add("manual");
        login.add("manualcontrasena");
        //insertarStrings();

        usuario = (EditText) findViewById(R.id.view_usuario);
        contrasena = (EditText) findViewById(R.id.view_contrasena);
        botonLogin = (Button)findViewById(R.id.view_botonLogin);
        //usuario.getText();
        //contrasena.getText();

        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(usuario.getText().toString());
                System.out.println(contrasena.getText().toString());
                serverConnection.sendMessage(usuario.getText().toString(), contrasena.getText().toString());
                if(logedIn){
                    startActivity(new Intent(MainActivity.this, Menu.class));
                }
               // SendMessage messageThread = new SendMessage(serverConnection.getObjectOS(), serverConnection.getObjectIS(), usuario.getText().toString(),
               //         contrasena.getText().toString());
               // messageThread.start();
                //Toast.makeText(getApplicationContext(), usuario.getText().toString(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(), contrasena.getText().toString(), Toast.LENGTH_SHORT).show();
             //   if (usuario.getText().toString().equals(login.get(0).toString()) && contrasena.getText().toString().equals(login.get(1).toString())){
               //     startActivity(new Intent(MainActivity.this, Menu.class));
                //}
            }
        });
    }

    /*private void insertarStrings() {

        SQLiteTabla con = new SQLiteTabla(this, "bd strings", null, 1);

        SQLiteDatabase db = con.getWritableDatabase();

        //añadir aqui los datos a introducir en sqlite
        ContentValues values = new ContentValues();
        values.put(Utilidades.ESPANOL, "Paso 1");    //1
        values.put(Utilidades.INGLES, "Step 1");     //1
        values.put(Utilidades.ESPANOL, "Paso 2");    //2
        values.put(Utilidades.INGLES, "Step 2");     //2
        values.put(Utilidades.ESPANOL, "Paso 3");    //3
        values.put(Utilidades.INGLES, "Step 3");     //3
        values.put(Utilidades.ESPANOL, "Paso 4");    //4
        values.put(Utilidades.INGLES, "Step 4");     //4
        values.put(Utilidades.ESPANOL, "Paso 5");    //5
        values.put(Utilidades.INGLES, "Step 5");     //5
        values.put(Utilidades.ESPANOL, "Paso n");    //6
        values.put(Utilidades.INGLES, "Step n");     //6
        values.put(Utilidades.ESPANOL, "Acerca de"); //7
        values.put(Utilidades.INGLES, "FAQ");        //7
        values.put(Utilidades.ESPANOL, "Al iniciar la aplicación veremos esta pequeña ventana en la que podremos loguearnos " +
                "si estamos previamente registrados en el sistema.\n" +
                "Para hacerlo, debemos introducir nuestro correo electrónico y nuestra contraseña, " +
                "después pulsaremos “Entrar” y nos dirigirá al siguiente paso.\n");  //8
        values.put(Utilidades.INGLES, "As soon as we launch the app, we can see a little window in which we can log in " +
                "if we were already registered in the system.\n" +
                "To do so, we will need to enter our email and password " +
                "and press “Enter”, leading us to the next step.");  //8
        values.put(Utilidades.ESPANOL, "FAQ:\n" +
                "Desarrollado por:\n" +
                "-\tAlejandro Sánchez Rodríguez\n" +
                "-\t.\n" +
                "-\t.\n" +
                "-\t.\n" +
                "\n" +
                "Grupo 2 Desarrollo de aplicaciones multiplataforma.\n" +
                "\n" +
                "Versión 1.\n"); //7
        values.put(Utilidades.INGLES, "FAQ:\n" +
                "Developed by:\n" +
                "-\tAlejandro Sánchez Rodríguez\n" +
                "-\t.\n" +
                "-\t.\n" +
                "-\t.\n" +
                "\n" +
                "Group 2 Desarrollo de aplicaciones multiplataforma.\n" +
                "\n" +
                "Version 1.\n");        //7


        Long espanolResult = db.insert(Utilidades.TABLA_STRINGS, Utilidades.ESPANOL, values);
        Long inglesResult = db.insert(Utilidades.TABLA_STRINGS, Utilidades.INGLES, values);

        db.close();
    }*/
}