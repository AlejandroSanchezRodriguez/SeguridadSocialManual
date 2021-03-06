package Server;

import com.example.seguridadsocialmanual.MainActivity;
import com.example.seguridadsocialmanual.Manual_Page;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Models.ContentModel;
import Models.ContentRequest;
import Models.DataRequestResponse;
import Models.LoginRequest;

public class SendMessage extends Thread{

    ObjectOutputStream objectOS;
    ObjectInputStream objectIS;
    DataRequestResponse message;

    public SendMessage(ObjectOutputStream objectOS, ObjectInputStream objectIS,DataRequestResponse message){
        this.objectOS = objectOS;
        this.objectIS = objectIS;
        this.message = message;
    }

    public void run(){
        try {
            objectOS.writeObject(message);
            DataRequestResponse response = (DataRequestResponse) objectIS.readObject();
            switch (response.getAction()){
                case "0002":
                    if (response.getError().equals("")) {
                        MainActivity.logedIn = true;
                    }
                    break;
                case "0003":
                    System.out.println(((ContentModel)response.getData().get(0)).getText());
                    Manual_Page.content = ((ContentModel)response.getData().get(0)).getText();
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}