/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isdcm.webapp1.model;

/**
 *
 * @author david
 */
public class User {
    private String firstname;
    private String surname;
    private String email;
    private String password;
    
    public User(){
        this.firstname = "";
        this.surname = "";
        this.password = "";
        this.email = "";
    }
    
    public User(String firstname, String surname, String password, String email){
        this.firstname = firstname;
        this.surname = surname;
        this.password = password;
        this.email = email;
    }
    
    // Getter and Setter methods for firstname
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    // Getter and Setter methods for surname
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Getter and Setter methods for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter methods for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
