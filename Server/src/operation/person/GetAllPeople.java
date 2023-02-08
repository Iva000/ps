/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.person;

import domain.Person;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Iva
 */
public class GetAllPeople extends AbstractGenericOperation{

    List<Person> people;

    public List<Person> getPeople() {
        return people;
    }
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        people = repository.getAll(param);
    }
    
}
