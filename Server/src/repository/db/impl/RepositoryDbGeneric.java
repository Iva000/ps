/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domain.GenericEntiy;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.db.DbConnectionFactory;
import repository.db.DbRepository;

/**
 *
 * @author Iva
 */
public class RepositoryDbGeneric implements DbRepository<GenericEntiy>{

    @Override
    public void add(GenericEntiy param) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(param.getTableName())
                    .append("(").append(param.getInsertColumns()).append(")")
                    .append(" VALUES (").append(param.getInsertValues()).append(")");
            String sql = sb.toString();
            System.out.println(sql);
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rsKeys = statement.getGeneratedKeys();
            if (rsKeys.next()) {
                int id = rsKeys.getInt(1);
                param.setId(id);
            }
            rsKeys.close();
            statement.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void edit(GenericEntiy param) throws Exception {
         try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ").append(param.getTableName()).append(" SET ").append(param.getUpdateValues()).append(" WHERE ").append(param.getIndentificator());
            String sql = sb.toString();
            System.out.println(sql);
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Update product DB error: \n" + ex.getMessage());
        }
    }

    @Override
    public void delete(GenericEntiy param) throws Exception {
        try{
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ").append(param.getTableName()).append(" WHERE ").append(param.getIndentificator());
            String sql = sb.toString();
            statement.executeUpdate(sql);
            statement.close();
        }catch(Exception ex){
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public List<GenericEntiy> getAll(GenericEntiy param) throws Exception {
        List<GenericEntiy> generics = new ArrayList<>();
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();

            sb.append("SELECT * FROM ").append(param.getTableName()).append(param.getJoinText());
            String sql = sb.toString();
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                generics.add(param.getEntiy(rs));
            }

            statement.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return generics;
    }

    @Override
    public List<GenericEntiy> getAllByCriteria(GenericEntiy param) {
        List<GenericEntiy> generics = new ArrayList<>();
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();

            sb.append("SELECT * FROM ").append(param.getTableName()).append(param.getJoinText()).append(param.getSelectValues(param));
            String sql = sb.toString();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                generics.add(param.getEntiy(rs));
            }

            statement.close();
        } catch (SQLException ex) {
            
        } catch (Exception ex) {
            Logger.getLogger(RepositoryDbGeneric.class.getName()).log(Level.SEVERE, null, ex);
        }
        return generics;
    }

    @Override
    public GenericEntiy get(GenericEntiy param) {
        GenericEntiy generic = null;
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            StringBuilder sb = new StringBuilder();

            sb.append("SELECT * FROM ").append(param.getTableName()).append(param.getJoinText()).append(" WHERE ").append(param.getIndentificator());
            String sql = sb.toString();
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                generic = param.getEntiy(rs);
            }

            statement.close();
       
        } catch (Exception ex) {
            Logger.getLogger(RepositoryDbGeneric.class.getName()).log(Level.SEVERE, null, ex);
        }
        return generic;
    }
    
}
