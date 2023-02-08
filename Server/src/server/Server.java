/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;

import form.FrmMain;
import form.tableModel.UserTableModel;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.element.ServerElement;
import thread.ProcessClientRequest;

/**
 *
 * @author Iva
 */
public class Server extends Thread{

//    public void startServer(){
//        try {
//            ServerSocket ss = new ServerSocket(9000);
//            
//            while(true){
//                Socket socket = ss.accept();
//                handleClient(socket);
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        
//    }
//
//    private void handleClient(Socket socket) {
//        ProcessClientRequest pcr = new ProcessClientRequest(socket);
//        pcr.start();
//    }
    
    
    private ServerSocket serverSocket;
    private List<ProcessClientRequest> clients;
    private FrmMain frmServer;

    public Server() {
        getPort();
        clients = new ArrayList<>();
    }

    @Override
    public void run() {
        
         
             while (true) {
                 try {
                     System.out.println("Waiting for connection....");
                     Socket socket = serverSocket.accept();
                     System.out.println("Connected with client...");
                     handleClient(socket);
                 } catch (IOException ex) {
                     System.out.println("Close all clients!");
                     closeAllClients();
                     return;
                 } catch (Exception ex) {
                     Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }

    }

    private void handleClient(Socket socket) throws Exception {
        ProcessClientRequest client = new ProcessClientRequest(socket);
        client.start();
        client.setServer(this);
        clients.add(client);
    }

    private void getPort() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(ServerElement.FILE_PATH_SERVER));
            System.out.println(properties.getProperty(ServerElement.PORT));
            serverSocket = new ServerSocket(Integer.valueOf(properties.getProperty(ServerElement.PORT)));
        } catch (Exception ex) {
            System.out.println("Cannot find port!");
        }
    }

    private void closeAllClients() {
        for (ProcessClientRequest client : clients) {
            client.closeSocket();
        }
        clients = new ArrayList<>();
        ((UserTableModel) frmServer.getTblUsers().getModel()).refresh(new ArrayList<>());
    }

    public void setFrmServer(FrmMain frmServer) {
        this.frmServer = frmServer;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void refreshTable(ProcessClientRequest client) {
        ((UserTableModel) frmServer.getTblUsers().getModel()).add(client.getUser());
    }

    public void delete(ProcessClientRequest client) {
        clients.remove(client);
        ((UserTableModel) frmServer.getTblUsers().getModel()).delete(client.getUser());
    }
}
