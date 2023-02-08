/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package commonCommunication;

import java.io.Serializable;

/**
 *
 * @author Iva
 */
public enum Operation implements Serializable{
    LOGIN,
    LOGOUT,
    PET_ADD,
    PERSON_ADD,
    GET_ALL_CITIES,
    GET_ALL_TYPES,
    GET_ALL_PEOPLE,
    GET_ALL_PETS,
    DELETE_PERSON,
    DELETE_PET,
    EDIT_PERSON,
    EDIT_PET,
    SEARCH_PEOPLE,
    SEARCH_PETS,
    ADOPTION_ADD,
    GET_ALL_ADOPTIONS,
    GET_PERSON,
    GET_PET
    
}
