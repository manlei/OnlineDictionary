import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Eric on 2016/11/25.
 */
public class Client {
    Socket socket;
    //input and output stream
    //private DataOutputStream toServer;
    //private DataInputStream fromServer;
    private ObjectOutputStream objectToServer;
    private ObjectInputStream objectFromServer;
    public Client() {
        try {
            socket=new Socket("localhost",8000);
            //toServer=new DataOutputStream(socket.getOutputStream());
            //fromServer=new DataInputStream(socket.getInputStream());
            objectToServer=new ObjectOutputStream(socket.getOutputStream());
            objectFromServer=new ObjectInputStream(socket.getInputStream());
        }
        catch (Exception ex) {
            //
        }
    }
    public void close() {
        try {
            objectToServer.close();
            objectFromServer.close();
            socket.close();
        }
        catch(Exception ex){
            //
        }
    }
    public void selectTranslator() {
        // TODO: 2016/11/25
    }
    public ArrayList<WORD> queryWord(String text) throws Exception{
        String message=new String("q"+text);
        objectToServer.writeObject(message);
        ArrayList<WORD> answer=(ArrayList<WORD>) objectFromServer.readObject();
        return  answer;
    }
    public void vote1() {

    }
    public void vote2() {

    }
    public void vote3() {

    }
    public boolean login(String[] info) {
        // TODO: 2016/11/25
        return false;
    }
}
