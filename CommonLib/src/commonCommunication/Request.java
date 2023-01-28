/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commonCommunication;

import java.io.Serializable;

/**
 *
 * @author Iva
 */
public class Request implements Serializable{
    
    private Object argument;
    private Operation operation;

    public Request(Object argument, Operation operation) {
        this.argument = argument;
        this.operation = operation;
    }

    public Object getArgument() {
        return argument;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
    
    
    
}
