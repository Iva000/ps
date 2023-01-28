/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domain.User;
import java.util.ArrayList;
import java.util.List;
import repository.db.DbRepository;
import java.sql. Connection;
import java.sql. Statement;
import java.sql. ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.db.DbConnectionFactory;

/**
 *
 * @author Iva
 */
public class RepositoryDbUser implements DbRepository<User>{

   

    @Override
    public void add(User param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void edit(User param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(User param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<User> getAll() {
        try {
            String sql = "SELECT * FROM USER";
            
            List<User> users = new ArrayList<>();
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                
                users.add(user);
            }
            rs.close();
            statement.close();
            return users;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<User> getAll(String param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
