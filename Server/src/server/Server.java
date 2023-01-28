/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import thread.ProcessClientRequest;

/**
 *
 * @author Iva
 */
public class Server {

    public void startServer(){
        try {
            ServerSocket ss = new ServerSocket(9000);
            
            while(true){
                Socket socket = ss.accept();
                handleClient(socket);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

    private void handleClient(Socket socket) {
        ProcessClientRequest pcr = new ProcessClientRequest(socket);
        pcr.start();
    }
    
}
