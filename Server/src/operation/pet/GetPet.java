/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.pet;

import domain.Pet;
import operation.AbstractGenericOperation;

/**
 *
 * @author Iva
 */
public class GetPet extends AbstractGenericOperation{

    Pet pet;

    public Pet getPet() {
        return pet;
    }
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        pet = (Pet)repository.get(param);
    }
    
}
