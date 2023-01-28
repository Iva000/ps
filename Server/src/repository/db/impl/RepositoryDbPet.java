/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domain.Pet;
import domain.Type;
import java.util.List;
import repository.db.DbRepository;
import java.sql. Connection;
import java.sql. PreparedStatement;
import java.sql. ResultSet;
import java.util.ArrayList;
import repository.db.DbConnectionFactory;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iva
 */
public class RepositoryDbPet implements DbRepository<Pet>{

    

    @Override
    public void add(Pet pet) throws Exception {
        try{
            String sql = "INSERT INTO PET VALUES(?,?,?,?,?)";
        
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, pet.getId());
            ps.setString(2, pet.getName());
            ps.setInt(3, pet.getAge());
            ps.setInt(4, pet.getType().getId());
            ps.setString(5, pet.getDescription());
        
            ps.executeUpdate();
            ps.close();
        }catch(Exception ex){
            throw new Exception("Novi ljubimac ne može biti dodat!");
        }
        
    }

    @Override
    public void edit(Pet pet) throws Exception {
        try{
            String sql = "UPDATE PET SET NAME=?, AGE=?, TYPE=?, DESCIPTION=? WHERE ID=?";
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pet.getName());
            ps.setInt(2, pet.getAge());
            ps.setInt(3, pet.getType().getId());
            ps.setString(4, pet.getDescription());
            ps.setInt(5, pet.getId());
            
            ps.executeUpdate();
            ps.close();
        }catch(Exception ex){
            throw new Exception("Ažuriranje nije uspelo!");
        }
    }

    @Override
    public void delete(Pet pet) throws Exception {
        try{
            String sql = "DELETE FROM PET WHERE ID=?";
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, pet.getId());
            ps.executeUpdate();
            ps.close();
        }catch(Exception ex){
            throw new Exception("Ljubimac ne može biti izbrisan!");
        }
    }

    @Override
    public List<Pet> getAll() {
        try {
            String sql = "SELECT P.ID AS ID, P.NAME AS NAME, P.AGE, P.DESCRIPTION, "
                    + "T.ID AS TID, T.NAME AS TNAME FROM PET P INNER JOIN TYPE T ON (P.TYPE = T.ID)";
            
            List<Pet> pets= new ArrayList<>();
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                Pet pet = new Pet();
                pet.setId(rs.getInt("id"));
                pet.setName(rs.getString("name"));
                pet.setAge(rs.getInt("age"));
                
                Type type = new Type();
                type.setId(rs.getInt("tid"));
                type.setName(rs.getString("tname"));
                pet.setType(type);
                pet.setDescription(rs.getString("description"));
                
                pets.add(pet);
            }
            rs.close();
            statement.close();
            return pets;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
       
    }

    @Override
    public List<Pet> getAll(String param) throws Exception {
         try {
            String sql = "SELECT P.ID AS ID, P.NAME AS NAME, P.AGE, P.DESCRIPTION, "
                    + "T.ID AS TID, T.NAME AS TNAME FROM PET P INNER JOIN TYPE T ON (P.TYPE = T.ID)"
                    +" WHERE P.NAME LIKE '%"+ param +"%'";
            
            List<Pet> pets= new ArrayList<>();
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                Pet pet = new Pet();
                pet.setId(rs.getInt("id"));
                pet.setName(rs.getString("name"));
                pet.setAge(rs.getInt("age"));
                
                Type type = new Type();
                type.setId(rs.getInt("tid"));
                type.setName(rs.getString("tname"));
                pet.setType(type);
                pet.setDescription(rs.getString("description"));
                
                pets.add(pet);
            }
            rs.close();
            statement.close();
            return pets;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
}
