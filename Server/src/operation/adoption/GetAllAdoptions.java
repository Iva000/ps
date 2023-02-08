/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.adoption;

import domain.Adoption;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Iva
 */
public class GetAllAdoptions extends AbstractGenericOperation{

    List<Adoption> adoptions;

    public List<Adoption> getAdoptions() {
        return adoptions;
    }
    
    @Override
    protected void preconditions(Object param) throws Exception {
        
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        adoptions = repository.getAll(param);
    }
    
}
