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
public class Pet implements GenericEntiy{
    
    private int id;
    private int age;
    private String name;
    private Gender gender;
    private Type type;
    private String description;

    public Pet() {
    }

    public Pet(int id, int age, String name, Gender gender,Type type, String description) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.type = type;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Type getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        hash = 53 * hash + this.age;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.type);
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
        final Pet other = (Pet) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.type, other.type);
    }

    @Override
    public String toString() {
        return id + ", " + type + ", " + name;
    }

    @Override
    public String getTableName() {
        return "pet";
    }

    @Override
    public String getInsertColumns() {
        return "id, name, age, type, description, gender";
    }

    @Override
    public String getInsertValues() {
        return "" + id + ", '" + name + "', " + age + ", " + type.getId() + ", '" + description + "', '" + gender.toString()+"'";
    }

    @Override
    public void setId(Object id) {
        this.id = (Integer) id;
    }

    @Override
    public String getUpdateValues() {
        return " name ='"+name + "', age=" + age + ", type=" + type.getId() + ", description='" + description + "', gender='" + gender.toString()+"'"; 
    }

    @Override
    public String getIndentificator(){
        return " pet.id = "+id;
    }

    @Override
    public GenericEntiy getEntiy(ResultSet rs) throws SQLException{
        Type type = new Type();
        return new Pet(rs.getInt("id"), rs.getInt("age"), rs.getString("pet.name"), Gender.valueOf(rs.getString("gender")), (Type) type.getEntiy(rs), rs.getString("description"));
    }

    @Override
    public String getJoinText() {
        return " inner join type on pet.type = type.id";
    }

    @Override
    public String getSelectValues(Object param) {
        return " where pet.name like '%"+((Pet)param).getName()+"%'";
    }
    
    
    
}
