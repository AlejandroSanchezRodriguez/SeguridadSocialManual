package Server;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection extends Thread{

    String ip;
    int port;
    Socket socket;
    ObjectInputStream objectIS;
    ObjectOutputStream objectOS;

    public Connection(String ip, int port){
        this.ip = ip;
        this.port = port;
    }

    public void run(){
        try {
            socket = new Socket(ip, port);
            objectOS = new ObjectOutputStream(socket.getOutputStream());
            objectIS = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String userName, String password){
        SendMessage messageThread = new SendMessage(objectOS,objectIS, userName, password);
        messageThread.start();
    }
}