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
public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException() {
        super("The user already exists!");
    }
}