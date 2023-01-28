/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;

/**
 *
 * @author Iva
 */
public interface Repository<T> {
    
    List<T> getAll(String param) throws Exception;
    void add(T param) throws Exception;
    void edit(T param) throws Exception;
    void delete(T param)throws Exception;
    List<T> getAll();
}