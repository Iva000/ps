/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import commonCommunication.Receiver;
import commonCommunication.Request;
import commonCommunication.Response;
import commonCommunication.Sender;
import controller.Controller;
import domain.Adoption;
import domain.Person;
import domain.Pet;
import domain.User;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.Server;

/**
 *
 * @author Iva
 */
public class ProcessClientRequest extends Thread{
    
    Socket socket;
    Sender sender;
    Receiver receiver;
    Server server;
    User user;
    boolean flag = true;

    public ProcessClientRequest(Socket socket) {
        this.socket = socket;
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    public void setServer(Server server) {
        this.server = server;
    }

    @Override
    public void run() {
        while(!socket.isClosed()){
            try {
                Request request = (Request)receiver.receive();
                Response response = new Response();
                try{
                    switch(request.getOperation()){
                        case LOGIN: 
                            User user = (User) request.getArgument();
                            User me = Controller.getInstance().login(user);
                            response.setResult(me);
                            this.user = me;
                            server.refreshTable(this);
                            break;
                        case PERSON_ADD:
                            Person person = (Person) request.getArgument();
                            Controller.getInstance().addPerson(person);
                            break;
                        case GET_ALL_CITIES:
                            response.setResult(Controller.getInstance().getAllCities());
                            break;
                        case GET_ALL_TYPES:
                            response.setResult(Controller.getInstance().getAllTypes());
                            break;
                        case PET_ADD:
                            Pet pet = (Pet) request.getArgument();
                            Controller.getInstance().addPet(pet);
                            break;
                        case GET_ALL_PEOPLE:
                            response.setResult(Controller.getInstance().getAllPeople());
                            break;
                        case GET_ALL_PETS:
                            response.setResult(Controller.getInstance().getAllPets());
                            break;
                        case DELETE_PERSON:
                            person = (Person) request.getArgument();
                            Controller.getInstance().deletePerson(person);
                            break;
                        case DELETE_PET:
                             pet = (Pet) request.getArgument();
                             Controller.getInstance().deletePet(pet);
                             break;
                        case EDIT_PERSON:
                            person = (Person) request.getArgument();
                            Controller.getInstance().editPerson(person);
                            break;
                        case EDIT_PET:
                            pet = (Pet) request.getArgument();
                            Controller.getInstance().editPet(pet);
                            break;
                        case SEARCH_PEOPLE:
                            person = (Person) request.getArgument();
                            response.setResult(Controller.getInstance().searchPeople(person));
                            break;
                        case SEARCH_PETS:
                            pet = (Pet) request.getArgument();
                            System.out.println(request.getArgument());
                            response.setResult(Controller.getInstance().searchPets(pet));
                            break;
                        case ADOPTION_ADD:
                            Adoption adoption = (Adoption)request.getArgument();
                            Controller.getInstance().addAdoption(adoption);
                            break;
                        case GET_ALL_ADOPTIONS:
                            response.setResult(Controller.getInstance().getAllAdoptions());
                            break;
                        case GET_PERSON:
                            person = (Person) request.getArgument();
                            response.setResult(Controller.getInstance().getPerson(person));
                            break;
                        case GET_PET:
                            pet = (Pet) request.getArgument();
                            response.setResult(Controller.getInstance().getPet(pet));
                            break;
                        case LOGOUT:
                            response.setResult("Uspesna odjava!");
                            server.delete(this);
                            flag = false;
                            break;
                    }
                }catch(Exception e){
                    e.printStackTrace();
                    response.setException(e);
                }
                sender.send(response);
                if(!flag){
                    return;
                }
                
            } catch (Exception ex) {
                Logger.getLogger(ProcessClientRequest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
     public void closeSocket() {
        flag = false;
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ProcessClientRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public User getUser() {
        return user;
    }
    
}
