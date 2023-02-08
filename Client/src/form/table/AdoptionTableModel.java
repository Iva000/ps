/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form.table;

import domain.Adoption;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Iva
 */
public class AdoptionTableModel extends AbstractTableModel{

    List<Adoption> adoptions;
    String[] columns = {"Udomitelj", "Ljubimac", "Datum", "Da li osoba prvi put udomljava", "Izveštaj veterinara"};

    public AdoptionTableModel(List<Adoption> adoptions) {
        this.adoptions = adoptions;
    }
    
    @Override
    public int getRowCount() {
        return adoptions.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 0 || columnIndex == 1 || columnIndex == 4)
            return String.class;
        if(columnIndex == 2)
            return LocalDate.class;
        if(columnIndex == 3)
            return Boolean.class;
        return null;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Adoption adoption = adoptions.get(rowIndex);
        
        switch(columnIndex){
            case 0: return adoption.getPerson().getName() + " " +adoption.getPerson().getSurname();
            case 1: return adoption.getPet().getType() + " " + adoption.getPet().getName();
            case 2: {
                DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("dd.MM.yyyy.");
                return dtf.format(adoption.getDate());
            }
            case 3: return adoption.isFirstTime();
            case 4: return adoption.getVetReport();
            default: return "n/a";
        }
    }
    
}
