package Server;

import com.example.seguridadsocialmanual.MainActivity;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Models.DataRequestResponse;
import Models.LoginRequest;

public class SendMessage extends Thread{

    ObjectOutputStream objectOS;
    ObjectInputStream objectIS;
    String userName, password;

    public SendMessage(ObjectOutputStream objectOS,    ObjectInputStream objectIS, String userName, String password){
        this.objectOS = objectOS;
        this.objectIS = objectIS;
        this.userName = userName;
        this.password = password;
    }

    public void run(){
        try {
            DataRequestResponse message = new DataRequestResponse();
            message.setAction("0002");
            LoginRequest loginData = new LoginRequest(userName, password);
            message.addData(loginData);
            objectOS.writeObject(message);
            if(((DataRequestResponse)objectIS.readObject()).getError().equals("")){
                MainActivity.logedIn = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
