/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.table;

import domain.Pet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Iva
 */
public class PetTableModel extends AbstractTableModel{

    private final List<Pet> pets;
    private final String[] columns = {"ID", "Ime", "Godine", "Vrsta", "Opis"};

    public PetTableModel(List<Pet> pets) {
        this.pets = pets;
    }
    
    @Override
    public int getRowCount() {
        if(pets!= null)
            return pets.size();
        return 0;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pet pet = pets.get(rowIndex);
        
        switch(columnIndex){
            case 0: return pet.getId();
            case 1: return pet.getName();
            case 2: return pet.getAge();
            case 3: return pet.getType();
            case 4: return pet.getDescription();
            default: return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
       return columns[column];
    }
    
    
}
