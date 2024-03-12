/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frycz.Mikolaj.Cw4.prototyp.Exceptions;

/**
 *This class is used for custom exception handling.
 * 
 * Exceptions are thrown in different classes in order to sort out errors.
 * @author mikol
 */
public class CustomException extends Exception {

    /**
     * This method is used to deploy custom exceptions.
     * @param argument Message that is displayed after an exception is thrown.
     */
    public CustomException(String argument) {
        super(argument);
    }
    
    
    
}
