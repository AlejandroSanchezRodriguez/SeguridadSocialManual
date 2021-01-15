package Server;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Models.DataRequestResponse;

public class Connection extends Thread{

    String ip;
    int port;
    Socket socket;
    ObjectInputStream objectIS;
    ObjectOutputStream objectOS;
    public boolean conected = false;

    public Connection(String ip, int port){
        this.ip = ip;
        this.port = port;
    }

    public void run(){
        try {
            socket = new Socket(ip, port);
            objectOS = new ObjectOutputStream(socket.getOutputStream());
            objectIS = new ObjectInputStream(socket.getInputStream());
            conected = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(DataRequestResponse message){
        SendMessage messageThread = new SendMessage(objectOS,objectIS,message);
        messageThread.start();
    }
}