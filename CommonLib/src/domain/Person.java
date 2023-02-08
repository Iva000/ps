/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author Iva
 */
public class Person implements GenericEntiy{
    
    private String jmbg;
    private String name;
    private String surname;
    private int year;
    private City city;
    private String phoneNumber;

    public Person() {
    }

    public Person(String jmbg, String name, String surname, int year, City city, String phoneNumber) {
        this.jmbg = jmbg;
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public String getJmbg() {
        return jmbg;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getYear() {
        return year;
    }

    public City getCity() {
        return city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.jmbg);
        hash = 19 * hash + Objects.hashCode(this.name);
        hash = 19 * hash + Objects.hashCode(this.surname);
        hash = 19 * hash + this.year;
        hash = 19 * hash + Objects.hashCode(this.city);
        hash = 19 * hash + Objects.hashCode(this.phoneNumber);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        return this.jmbg == other.jmbg;
    }

    @Override
    public String toString() {
        return getJmbg() + ", " + getName() + " " + getSurname();
    }

    @Override
    public String getTableName() {
        return "person";
    }

    @Override
    public String getInsertColumns() {
        return " jmbg, name, surname, year_of_birth, city, phone_number ";
    }

    @Override
    public String getInsertValues() {
        return "'" + jmbg + "', '" + name + "', '" + surname + "', " + year + ", " + city.getId() + ", '" + phoneNumber+"'";
    }

    @Override
    public void setId(Object id) {
        this.jmbg = (String) jmbg;
    }

    @Override
    public String getUpdateValues() {
        return "name ='"+ name + "', surname='" + surname + "', year_of_birth=" +year+", city="+ city.getId() + ", phone_number='"+ phoneNumber+"'";
    }

    @Override
    public String getIndentificator() {
        return " person.jmbg=" + jmbg;
    }

    @Override
    public GenericEntiy getEntiy(ResultSet rs) throws SQLException{
        City city = new City();
        return new Person(rs.getString("jmbg"), rs.getString("person.name"), rs.getString("surname"), rs.getInt("year_of_birth"), (City)city.getEntiy(rs), rs.getString("phone_number"));
    }

    @Override
    public String getJoinText() {
        return " INNER JOIN CITY ON PERSON.CITY=CITY.ID ";
    }

    @Override
    public String getSelectValues(Object param) {
        return " WHERE person.surname LIKE '%"+((Person) param).getSurname()+"%'";
    }
    
    
    
}
