/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package commonCommunication;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Iva
 */
public class Sender {

    Socket socket;

    public Sender(Socket socket) {
        this.socket = socket;
    }
    
    public void send(Object object) throws Exception{
       try{
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(object);
            out.flush();
       }catch(Exception ex){
           ex.printStackTrace();
           throw new Exception("Error sending object! "+ ex.getMessage());
       }
    }
    
}
