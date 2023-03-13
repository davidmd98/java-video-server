/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isdcm.webapp1.exception;

/**
 *
 * @author david
 */
public class InvalidUserException extends Exception{
    public InvalidUserException(){
        super("Invalid user");
    }
}
