/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domain.City;
import domain.Person;
import domain.Pet;
import domain.Type;
import java.sql. Connection;
import java.sql. PreparedStatement;
import java.sql. Statement;
import java.sql. ResultSet;
import java.util.ArrayList;
import java.util.List;
import repository.db.DbConnectionFactory;
import repository.db.DbRepository;
/**
 *
 * @author Iva
 */
public class RepositoryDbPerson implements DbRepository<Person>{

    @Override
    public void add(Person person) throws Exception {
        try{
            String sql = "INSERT INTO PERSON VALUES (?,?,?,?,?,?)";
        
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, person.getJmbg());
            ps.setString(2, person.getName());
            ps.setString(3, person.getSurname());
            ps.setInt(4, person.getYear());
            ps.setInt(5, person.getCity().getId());
            ps.setString(6, person.getPhoneNumber());
        
            ps.executeUpdate();
            ps.close();
            connection.commit();
        }catch(Exception ex){
            throw new Exception("Novi udomitelj ne može biti sačuvan!");
        }
    }

    @Override
    public void edit(Person person) throws Exception {
        try{
            String sql = "UPDATE PERSON SET NAME=?, SURNAME=?, YEAR_OF_BIRTH=?, CITY=?, PHONE_NUMBER=? WHERE JMBG=?";
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, person.getName());
            ps.setString(2, person.getSurname());
            ps.setInt(3, person.getYear());
            ps.setInt(4, person.getCity().getId());
            ps.setString(5, person.getPhoneNumber());
            ps.setString(6, person.getJmbg());
            
            ps.executeUpdate();
            ps.close();
        }catch(Exception ex){
            throw new Exception("Ažuriranje nije uspelo!");
        }
    }

    @Override
    public void delete(Person person) throws Exception {
        try{
            String sql = "DELETE FROM PERSON WHERE JMBG ='" + person.getJmbg() +"'";
            System.out.println(sql);
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        }catch(Exception ex){
            throw new Exception("Udomitelj ne može biti izbrisan!");
        }
    }

    @Override
    public List<Person> getAll() {
        try {
            String sql = "SELECT P.JMBG, P.NAME AS NAME, P.SURNAME, P.YEAR_OF_BIRTH, P.PHONE_NUMBER, "
                    + "C.ID AS CID, C.NAME AS CNAME FROM PERSON P INNER JOIN CITY C ON (P.CITY = C.ID)";
            
            List<Person> people= new ArrayList<>();
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                Person person = new Person();
                person.setJmbg(rs.getString("jmbg"));
                person.setName(rs.getString("name"));
                person.setSurname(rs.getString("surname"));
                person.setYear(rs.getInt("year_of_birth"));
                City city = new City();
                city.setId(rs.getInt("cid"));
                city.setName(rs.getString("cname"));
                person.setCity(city);
                person.setPhoneNumber(rs.getString("phone_number"));
                
                people.add(person);
            }
            rs.close();
            statement.close();
            return people;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Person> getAll(String param) throws Exception {
        try {
            String sql = "SELECT P.JMBG, P.NAME AS NAME, P.SURNAME, P.YEAR_OF_BIRTH, P.PHONE_NUMBER, "
                    + "C.ID AS CID, C.NAME AS CNAME FROM PERSON P INNER JOIN CITY C ON (P.CITY = C.ID)"
                    +"WHERE P.SURNAME LIKE '%"+param+"%'";
            
            List<Person> people= new ArrayList<>();
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                Person person = new Person();
                person.setJmbg(rs.getString("jmbg"));
                person.setName(rs.getString("name"));
                person.setSurname(rs.getString("surname"));
                person.setYear(rs.getInt("year_of_birth"));
                City city = new City();
                city.setId(rs.getInt("cid"));
                city.setName(rs.getString("cname"));
                person.setCity(city);
                person.setPhoneNumber(rs.getString("phone_number"));
                
                people.add(person);
            }
            rs.close();
            statement.close();
            return people;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        
    }
    
}
