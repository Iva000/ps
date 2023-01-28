/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Person;
import domain.Pet;
import domain.User;
import java.util.List;
import repository.Repository;
import repository.db.DbRepository;
import repository.db.impl.RepositoryDbCity;
import repository.db.impl.RepositoryDbPerson;
import repository.db.impl.RepositoryDbPet;
import repository.db.impl.RepositoryDbType;
import repository.db.impl.RepositoryDbUser;

/**
 *
 * @author Iva
 */
public class Controller {
    
    private final Repository repositoryUser;
    private final Repository repositoryPerson;
    private final Repository repositoryCity;
    private final Repository repositoryType;
    private final Repository repositoryPet;
    
    private static Controller instance;

    public Controller() {
        this.repositoryUser = new RepositoryDbUser();
        this.repositoryPerson = new RepositoryDbPerson();
        this.repositoryCity = new RepositoryDbCity();
        this.repositoryType = new RepositoryDbType();
        this.repositoryPet = new RepositoryDbPet();
    }

    public static Controller getInstance() {
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }
    
    public User login(String username, String password) throws Exception{
        List<User> users = repositoryUser.getAll();
        
        for(User user : users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
        }    
        throw new Exception("User not found!");
    }

    public void addPerson(Person person) throws Exception {
        ((DbRepository) repositoryPerson).connect();
        
        try{
            repositoryPerson.add(person);
            ((DbRepository) repositoryPerson).commit();
        }catch(Exception ex){
            ex.printStackTrace();
            ((DbRepository) repositoryPerson).rollback();
        }finally{
            ((DbRepository) repositoryPerson).disconnect();
        }
    }

    public Object getAllCities() throws Exception {
        return repositoryCity.getAll();
    }
    
    public Object getAllTypes() throws Exception{
        return repositoryType.getAll();
    }
    
    public void addPet(Pet pet) throws Exception{
        ((DbRepository) repositoryPet).connect();
        
        try{
            repositoryPet.add(pet);
            ((DbRepository) repositoryPet).commit();
        }catch(Exception ex){
            ex.printStackTrace();
            ((DbRepository) repositoryPet).rollback();
        }finally{
            ((DbRepository) repositoryPet).disconnect();
        }
    }
    
    public Object getAllPeople() throws Exception{
        return repositoryPerson.getAll();
    }
    
    public Object getAllPets() throws Exception{
        return repositoryPet.getAll();
    }
    
    public void deletePerson(Person person) throws Exception{
        ((DbRepository) repositoryPerson).connect();
        
        try{
            repositoryPerson.delete(person);
            ((DbRepository) repositoryPerson).commit();
        }catch(Exception ex){
            ex.printStackTrace();
            ((DbRepository) repositoryPerson).rollback();
        }finally{
            ((DbRepository) repositoryPerson).disconnect();
        }
    }
    
    public void deletePet(Pet pet) throws Exception{
        ((DbRepository) repositoryPet).connect();
        
        try{
            repositoryPet.delete(pet);
            ((DbRepository) repositoryPet).commit();
        }catch(Exception ex){
            ex.printStackTrace();
            ((DbRepository) repositoryPet).rollback();
        }finally{
            ((DbRepository) repositoryPet).disconnect();
        }
    }

    public void editPerson(Person person) throws Exception {
        ((DbRepository) repositoryPerson).connect();
        
        try{
            repositoryPerson.edit(person);
            ((DbRepository) repositoryPerson).commit();
        }catch(Exception ex){
            ex.printStackTrace();
            ((DbRepository) repositoryPerson).rollback();
        }finally{
            ((DbRepository) repositoryPerson).disconnect();
        }
    }

    public void editPet(Pet pet) throws Exception {
        ((DbRepository) repositoryPet).connect();
        
        try{
            repositoryPet.edit(pet);
            ((DbRepository) repositoryPet).commit();
        }catch(Exception ex){
            ex.printStackTrace();
            ((DbRepository) repositoryPet).rollback();
        }finally{
            ((DbRepository) repositoryPet).disconnect();
        }
    }
    
    public Object searchPeople(String syllable) throws Exception{
        return repositoryPerson.getAll(syllable);
    }
    
    public Object searchPets(String syllable) throws Exception{
        return repositoryPet.getAll(syllable);
    }
}
