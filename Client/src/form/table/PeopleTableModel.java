/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.table;

import domain.Person;
import java.util.List;
import javax.swing.table.AbstractTableModel;



/**
 *
 * @author Iva
 */
public class PeopleTableModel extends AbstractTableModel{
    
    private final List<Person> people;
    private final String[] columns = {"JMBG", "Ime", "Prezime", "Godina rođenja", "Grad", "Broj telefona"};

    public PeopleTableModel(List<Person> people) {
        this.people = people;
    }

    @Override
    public int getRowCount() {
        if(people!=null)
            return people.size();
        return 0;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = people.get(rowIndex);
        
        switch(columnIndex){
            case 0: return person.getJmbg();
            case 1: return person.getName();
            case 2: return person.getSurname();
            case 3: return person.getYear();
            case 4: return person.getCity();
            case 5: return person.getPhoneNumber();
            default: return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    
}
