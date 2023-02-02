/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Iva
 */
public class Adoption implements Serializable{
    
    Person person;
    Pet pet;
    LocalDate date;
    boolean firstTime;
    String vetReport;

    public Adoption() {
    }

    public Adoption(Person person, Pet pet, LocalDate date, boolean firstTime, String vetReport) {
        this.person = person;
        this.pet = pet;
        this.date = date;
        this.firstTime = firstTime;
        this.vetReport = vetReport;
    }

    public Person getPerson() {
        return person;
    }

    public Pet getPet() {
        return pet;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isFirstTime() {
        return firstTime;
    }

    public String getVetReport() {
        return vetReport;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setFirstTime(boolean firstTime) {
        this.firstTime = firstTime;
    }

    public void setVetReport(String vetReport) {
        this.vetReport = vetReport;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.person);
        hash = 89 * hash + Objects.hashCode(this.pet);
        hash = 89 * hash + Objects.hashCode(this.date);
        hash = 89 * hash + (this.firstTime ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.vetReport);
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
        final Adoption other = (Adoption) obj;
        if (this.pet != other.pet) {
            return false;
        }
        if (this.firstTime != other.firstTime) {
            return false;
        }
        if (!Objects.equals(this.person, other.person)) {
            return false;
        }
        if (!Objects.equals(this.vetReport, other.vetReport)) {
            return false;
        }
        return Objects.equals(this.date, other.date);
    }
    
    
    
}
