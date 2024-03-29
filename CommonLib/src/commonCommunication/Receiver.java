/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commonCommunication;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author Iva
 */
public class Receiver {
    
    Socket socket;

    public Receiver(Socket socket) {
        this.socket = socket;
    }
    
    public Object receive() throws Exception{
        try{
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception("Error receiving object!" + ex.getMessage());
        }
    }
    
}
