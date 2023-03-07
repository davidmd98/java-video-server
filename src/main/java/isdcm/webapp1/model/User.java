/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isdcm.webapp1.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author david
 */
public class User {
    private int id;
    private String firstname;
    private String surname;
    private String email;
    private String password;
    
    public User(){
        this.id = 0;
        this.firstname = "";
        this.surname = "";
        this.password = "";
        this.email = "";
    }
    
    public User(int id, String firstname, String surname, String password, String email){
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.password = password;
        this.email = email;
    }
    
    // Getter and Setter methods for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public static boolean exists(String username) throws ClassNotFoundException, SQLException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/pr2;user=pr2;password=pr2");
        PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM USERS WHERE username = ?");
        preparedStatement.setString(1, username);
        return preparedStatement.executeQuery().next();
    }
    
    public static boolean checkPassword(String username, String password) throws ClassNotFoundException, SQLException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/pr2;user=pr2;password=pr2");
        PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM USERS WHERE username = ? AND password = ?");
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        return preparedStatement.executeQuery().next();
    }
    
    public static boolean insertUser(String username, String firstname, String surname, String email, String password) throws ClassNotFoundException, SQLException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/pr2;user=pr2;password=pr2");
        
        PreparedStatement preparedStatement = c.prepareStatement("INSERT INTO users (username, password, firstname, surname, email) VALUES (?, ?, ?, ?, ?)");
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, firstname);
        preparedStatement.setString(4, surname);
        preparedStatement.setString(5, email);
        preparedStatement.executeUpdate();
        
        return true;
    }
}
