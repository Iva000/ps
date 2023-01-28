/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domain.Type;
import java.util.List;
import repository.db.DbRepository;
import java.sql. Connection;
import java.sql. Statement;
import java.sql. ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.db.DbConnectionFactory;

/**
 *
 * @author Iva
 */
public class RepositoryDbType implements DbRepository<Type>{

   

    @Override
    public void add(Type param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void edit(Type param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Type param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Type> getAll() {
        try {
            String sql = "SELECT * FROM TYPE";
            
            List<Type> types = new ArrayList<>();
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Type type = new Type();
                type.setId(rs.getInt("id"));
                type.setName(rs.getString("name"));
                
                types.add(type);
            }
            rs.close();
            statement.close();
            return types;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Type> getAll(String param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
