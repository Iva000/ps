/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domain.Adoption;
import domain.City;
import domain.Person;
import domain.Pet;
import domain.Type;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql. Statement;
import java.sql. ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import repository.db.DbConnectionFactory;
import repository.db.DbRepository;

/**
 *
 * @author Iva
 */
public class RepositoryDbAdoption implements DbRepository<Adoption>{

    @Override
    public List<Adoption> getAll(String param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(Adoption adoption) throws Exception {
        try{
            String sql = "INSERT INTO ADOPTION VALUES (?,?,?,?,?)";
            
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(adoption.getDate()));
            ps.setBoolean(2, adoption.isFirstTime());
            ps.setString(3, adoption.getVetReport());
            ps.setInt(4, adoption.getPet().getId());
            ps.setString(5, adoption.getPerson().getJmbg());
        
            ps.executeUpdate();
            ps.close();
            connection.commit();
        }catch(Exception ex){
            throw new Exception("Čuvanje udomljavanja nije uspelo!");
        }
    }

    @Override
    public void edit(Adoption param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Adoption param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Adoption> getAll() {
        try{
            String sql = "SELECT * FROM ADOPTION A INNER JOIN PET P ON (A.PETID = P.ID) "
                    + "INNER JOIN PERSON PE ON (A.PERSONID = PE.JMBG) "
                    + "INNER JOIN CITY C ON (PE.CITY = C.ID) "
                    + "INNER JOIN TYPE T ON (P.TYPE = T.ID)";
            
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            List<Adoption> adoptions= new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                Adoption adoption = new Adoption();
                adoption.setDate(LocalDate.parse(rs.getDate("date").toString()));
                adoption.setFirstTime(rs.getBoolean("firstTime"));
                adoption.setVetReport(rs.getString("vetReport"));
                Person person = new Person();
                person.setJmbg(rs.getString("pe.jmbg"));
                person.setName(rs.getString("pe.name"));
                person.setSurname(rs.getString("pe.surname"));
                person.setYear(rs.getInt("pe.year_of_birth"));
//                City city = new City();
//                city.setId(rs.getInt("cid"));
//                city.setName(rs.getString("cname"));
                person.setCity(null);
                person.setPhoneNumber(rs.getString("pe.phone_number"));
                adoption.setPerson(person);
                Pet pet = new Pet();
                pet.setId(rs.getInt("p.id"));
                pet.setName(rs.getString("p.name"));
                pet.setAge(rs.getInt("p.age"));
                
                Type type = new Type();
                type.setId(rs.getInt("t.id"));
                type.setName(rs.getString("t.name"));
                pet.setType(type);
                pet.setDescription(rs.getString("p.description"));
                adoption.setPet(pet);
                
                adoptions.add(adoption);
            }
            rs.close();
            statement.close();
            return adoptions;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
}
