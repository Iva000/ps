/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.type;

import domain.Type;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Iva
 */
public class GetAllTypes extends AbstractGenericOperation{

    List<Type> types; 

    public List<Type> getTypes() {
        return types;
    }
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        types = repository.getAll(param);
    }
    
}
