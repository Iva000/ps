/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.tableModel;

import domain.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Iva
 */
public class UserTableModel extends AbstractTableModel{
    
    private List<User> users;

    public UserTableModel() {
        users = new ArrayList<>();
    }

    public UserTableModel(List<User> users) {
        this.users = users;
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        String[] columns = {"Korisničko ime", "Ime i prezime"};
        return columns[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User user = users.get(rowIndex);
        
        switch(columnIndex){
            case 0: return user.getUsername();
            case 1: return user.getFirstname() + " " + user.getLastname();
            default: return "n/a";
        }
    }
    
    public void refresh(ArrayList<User> users){
        this.users = users;
        fireTableDataChanged();
    }
    
    public void add(User user){
        users.add(user);
        fireTableDataChanged();
    }
    
    public void delete(User user){
        users.remove(user);
        fireTableDataChanged();
    }
}
