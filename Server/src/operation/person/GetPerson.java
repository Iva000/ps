/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.person;

import domain.Person;
import operation.AbstractGenericOperation;

/**
 *
 * @author Iva
 */
public class GetPerson extends AbstractGenericOperation{

    Person person;

    public Person getPerson() {
        return person;
    }
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        person = (Person)repository.get(param);
    }
    
}
