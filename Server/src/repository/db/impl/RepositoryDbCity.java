/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domain.City;
import java.util.ArrayList;
import java.util.List;
import repository.db.DbRepository;
import java.sql. Connection;
import java.sql. Statement;
import java.sql. ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.db.DbConnectionFactory;

/**
 *
 * @author Iva
 */
public class RepositoryDbCity implements DbRepository<City>{

   

    @Override
    public void add(City param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void edit(City param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(City param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<City> getAll() {
        try {
            String sql = "SELECT * FROM CITY";
            
            List<City> cities = new ArrayList<>();
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                City city = new City();
                city.setId(rs.getInt("id"));
                city.setName(rs.getString("name"));
                
                cities.add(city);
            }
            rs.close();
            statement.close();
            return cities;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<City> getAll(String param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
