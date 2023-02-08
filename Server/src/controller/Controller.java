/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Adoption;
import domain.City;
import domain.Person;
import domain.Pet;
import domain.Type;
import domain.User;
import java.util.List;
import operation.AbstractGenericOperation;
import operation.adoption.AddAdoption;
import operation.adoption.GetAllAdoptions;
import operation.city.GetAllCities;
import operation.person.AddPerson;
import operation.person.DeletePerson;
import operation.person.EditPerson;
import operation.person.GetAllPeople;
import operation.person.GetAllPeopleByCriteria;
import operation.person.GetPerson;
import operation.pet.AddPet;
import operation.pet.DeletePet;
import operation.pet.EditPet;
import operation.pet.GetAllPets;
import operation.pet.GetAllPetsByCriteria;
import operation.pet.GetPet;
import operation.type.GetAllTypes;
import operation.user.GetAllUsers;
import repository.Repository;
import repository.db.DbRepository;


/**
 *
 * @author Iva
 */
public class Controller {
    
//    private final Repository repositoryUser;
//    private final Repository repositoryPerson;
//    private final Repository repositoryCity;
//    private final Repository repositoryType;
//    private final Repository repositoryPet;
//    private final Repository repositoryAdoption;
    
    private static Controller instance;

//    public Controller() {
//        this.repositoryUser = new RepositoryDbUser();
//        this.repositoryPerson = new RepositoryDbPerson();
//        this.repositoryCity = new RepositoryDbCity();
//        this.repositoryType = new RepositoryDbType();
//        this.repositoryPet = new RepositoryDbPet();
//        this.repositoryAdoption = new RepositoryDbAdoption();
//    }

    public static Controller getInstance() {
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }
    
    public User login(User user) throws Exception{
        AbstractGenericOperation getAllUser = new GetAllUsers();
        getAllUser.excecute(user);
        User u = ((GetAllUsers)getAllUser).getUserLogin();
        return u;
    }

    public void addPerson(Person person) throws Exception {
       AbstractGenericOperation addPerson = new AddPerson();
       addPerson.excecute(person);
    }

    public Object getAllCities() throws Exception {
        AbstractGenericOperation getAllCities = new GetAllCities();
        getAllCities.excecute(new City());
        List<City> cities = ((GetAllCities) getAllCities).getCities();
        return cities;
    }
    
    public Object getAllTypes() throws Exception{
        AbstractGenericOperation getAllTypes = new GetAllTypes();
        getAllTypes.excecute(new Type());
        List<Type> types = ((GetAllTypes) getAllTypes).getTypes();
        return types;
    }
    
    public void addPet(Pet pet) throws Exception{
       AbstractGenericOperation addPet = new AddPet();
       addPet.excecute(pet);
    }
    
    public Object getAllPeople() throws Exception{
        AbstractGenericOperation getAllPeople = new GetAllPeople();
        getAllPeople.excecute(new Person());
        List<Person> people = ((GetAllPeople) getAllPeople).getPeople();
        return people;
    }
    
    public Object getAllPets() throws Exception{
        AbstractGenericOperation getAllPets = new GetAllPets();
        getAllPets.excecute(new Pet());
        List<Pet> pets = ((GetAllPets) getAllPets).getPets();
        return pets;
    }
    
    public void deletePerson(Person person) throws Exception{
        AbstractGenericOperation deletePerson = new DeletePerson();
        deletePerson.excecute(person);
    }
    
    public void deletePet(Pet pet) throws Exception{
        AbstractGenericOperation deletePet = new DeletePet();
        deletePet.excecute(pet);
    }

    public void editPerson(Person person) throws Exception {
        AbstractGenericOperation editPerson = new EditPerson();
        editPerson.excecute(person);
    }

    public void editPet(Pet pet) throws Exception {
        AbstractGenericOperation editPet = new EditPet();
        editPet.excecute(pet);
    }
    
    public Object searchPeople(Person person) throws Exception{
        AbstractGenericOperation getPeopleByCriteria = new GetAllPeopleByCriteria();
        getPeopleByCriteria.excecute(person);
        List<Person> people = ((GetAllPeopleByCriteria) getPeopleByCriteria).getPeople();
        return people;
    }
    
    public Object searchPets(Pet pet) throws Exception{
        AbstractGenericOperation getPetsByCriteria = new GetAllPetsByCriteria();
        getPetsByCriteria.excecute(pet);
        List<Pet> pets = ((GetAllPetsByCriteria) getPetsByCriteria).getPets();
        return pets;
    }
    
    public void addAdoption(Adoption adoption) throws Exception{
        AbstractGenericOperation addAdoption = new AddAdoption();
        addAdoption.excecute(adoption);
    }
    
    public Object getAllAdoptions() throws Exception{
        AbstractGenericOperation getAllAdoptions = new GetAllAdoptions();
        getAllAdoptions.excecute(new Adoption());
        List<Adoption> adoptions = ((GetAllAdoptions) getAllAdoptions).getAdoptions();
        return adoptions;
    }
    
    public Object getPerson(Person person) throws Exception{
        AbstractGenericOperation getPerson = new GetPerson();
        getPerson.excecute(person);
        Person p = ((GetPerson) getPerson).getPerson();
        return p;
    }
    
    public Object getPet(Pet pet) throws Exception{
        AbstractGenericOperation getPet = new GetPet();
        getPet.excecute(pet);
        Pet p = ((GetPet) getPet).getPet();
        return p;
    }
}
