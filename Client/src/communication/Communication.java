/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import commonCommunication.Operation;
import commonCommunication.Receiver;
import commonCommunication.Request;
import commonCommunication.Response;
import commonCommunication.Sender;
import domain.Adoption;
import domain.City;
import domain.Person;
import domain.Pet;
import domain.Type;
import domain.User;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Iva
 */
public class Communication {
    
    Socket socket;
    Sender sender;
    Receiver receiver;
    private static Communication instance;

    public Communication() throws Exception{
        socket = new Socket("localhost", 9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }
    
    public static Communication getInstance() throws Exception{
        if(instance == null)
            instance = new Communication();
        return instance;
    }
    
    public User login(String username, String password)throws Exception{
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        
        Request request = new Request(user, Operation.LOGIN);
        sender.send(request);
        
        Response response =(Response) receiver.receive();
        
        if(response.getException()==null){
            return (User)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public String logOut() throws Exception {
        Request request = new Request(null, Operation.LOGOUT);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return  response.getResult().toString();
        } else {
            throw response.getException();
        }
    }
    
    public List<City> getAllCities() throws Exception{
        Request request = new Request(null, Operation.GET_ALL_CITIES);
        sender.send(request);
        
        Response response = (Response) receiver.receive();
        
        if(response.getException()==null)
            return (List<City>) response.getResult();
        else {
            throw response.getException();
        }
    }

    public void addPerson(Person person) throws Exception {
        Request request = new Request(person, Operation.PERSON_ADD);
        sender.send(request);
        
        Response response = (Response) receiver.receive();
        
        if(response.getException()== null){
        }
        else{
            throw response.getException();
        }
    }

    public List<Type> getAllTypes() throws Exception {
        Request request = new Request(null, Operation.GET_ALL_TYPES);
        sender.send(request);
        
        Response response = (Response) receiver.receive();
        
        if(response.getException()== null){
            return (List<Type>) response.getResult();
        }
        else{
            throw response.getException();
        }
    }
    
    public void addPet(Pet pet) throws Exception{
        Request request = new Request(pet, Operation.PET_ADD);
        sender.send(request);
        
        Response response = (Response) receiver.receive();
        if(response.getException() == null){
        }
        else{
            throw response.getException();
        }
    }

    public List<Person> getAllPeople() throws Exception {
        Request request = new Request(null, Operation.GET_ALL_PEOPLE);
        sender.send(request);
        
        Response response = (Response) receiver.receive();
        
        if(response.getException()== null){
            return (List<Person>) response.getResult();
        }
        else{
            throw response.getException();
        }
    }

    public List<Pet> getAllPets() throws Exception {
        Request request = new Request(null, Operation.GET_ALL_PETS);
        sender.send(request);
        
        Response response = (Response) receiver.receive();
        
        if(response.getException()== null){
            return (List<Pet>) response.getResult();
        }
        else{
            throw response.getException();
        }
    }

    public void deletePerson(Person person) throws Exception {
        Request request = new Request(person, Operation.DELETE_PERSON);
        sender.send(request);
        
        Response response = (Response) receiver.receive();
        
        if(response.getException() == null){
            
        }else{
            throw response.getException();
        }
    }
    
    public void deletePet(Pet pet) throws Exception{
        Request request = new Request(pet, Operation.DELETE_PET);
        sender.send(request);
        
        Response response = (Response) receiver.receive();
        
        if(response.getException() == null){
            
        }else{
            throw response.getException();
        }
    }

    public void editPerson(Person person) throws Exception {
        Request request = new Request(person, Operation.EDIT_PERSON);
        sender.send(request);
        
        Response response = (Response) receiver.receive();
        
        if(response.getException() == null){
            
        }else{
            throw response.getException();
        }
    }
    
    public void editPet(Pet pet) throws Exception {
        Request request = new Request(pet, Operation.EDIT_PET);
        sender.send(request);
        
        Response response = (Response) receiver.receive();
        
        if(response.getException() == null){
            
        }else{
            throw response.getException();
        }
    }
    
    public List<Person> searchPeople(Person person) throws Exception{
        Request request = new Request(person, Operation.SEARCH_PEOPLE);
        sender.send(request);
        
        Response response = (Response) receiver.receive();
        
        if(response.getException()== null){
            return (List<Person>) response.getResult();
        }
        else{
            throw response.getException();
        }
    }

    public List<Pet> searchPets(Pet pet) throws Exception {
        Request request = new Request(pet, Operation.SEARCH_PETS);
        sender.send(request);
        
        Response response = (Response) receiver.receive();
        
        if(response.getException()== null){
            return (List<Pet>) response.getResult();
        }
        else{
            throw response.getException();
        }
    }
    
    public void addAdoption(Adoption adoption) throws Exception{
        Request request = new Request(adoption, Operation.ADOPTION_ADD);
        sender.send(request);
        
        Response response = (Response) receiver.receive();
        if(response.getException() == null){
        }
        else{
            throw response.getException();
        }
    }
    
    public List<Adoption> getAllAdoptions() throws Exception {
        Request request = new Request(null, Operation.GET_ALL_ADOPTIONS);
        sender.send(request);
        
        Response response = (Response) receiver.receive();
        
        if(response.getException()== null){
            return (List<Adoption>) response.getResult();
        }
        else{
            throw response.getException();
        }
    }
    
    public Person getPerson(Person person) throws Exception{
        Request request = new Request(person, Operation.GET_PERSON);
        sender.send(request);
        
        Response response = (Response) receiver.receive();
        
        if(response.getException()== null){
            return (Person) response.getResult();
        }
        else{
            throw response.getException();
        }
    }
    
     public Pet getPet(Pet pet) throws Exception{
        Request request = new Request(pet, Operation.GET_PET);
        sender.send(request);
        
        Response response = (Response) receiver.receive();
        
        if(response.getException()== null){
            return (Pet) response.getResult();
        }
        else{
            throw response.getException();
        }
    }
}
