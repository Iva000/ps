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
public class Response implements Serializable{
    
    Object result;
    Exception exception;

    public Response() {
    }

    public Response(Object result, Exception exception) {
        this.result = result;
        this.exception = exception;
    }

    public Object getResult() {
        return result;
    }

    public Exception getException() {
        return exception;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
    
    
    
}
