/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Iva
 */
public interface GenericEntiy extends Serializable{
    
    public String getTableName();

    public String getInsertColumns();

    public String getInsertValues();

    void setId(Object id);

    public String getUpdateValues();

    public String getIndentificator();

    public GenericEntiy getEntiy(ResultSet rs) throws SQLException;

    public String getJoinText();

    public String getSelectValues(Object param);
    
}
