package isdcm.webapp1.model;

/**
 *
 * @author david
 */
public class User {
    private String username;
    private String firstname;
    private String surname;
    private String email;
    private String password;
    
    public User(){
        this.username = "";
        this.firstname = "";
        this.surname = "";
        this.password = "";
        this.email = "";
    }
    
    public User(String username, String firstname, String surname, String password, String email){
        this.username = username;
        this.firstname = firstname;
        this.surname = surname;
        this.password = password;
        this.email = email;
    }
    
    public User(String username, String firstname, String surname, String email){
        this.username = username;
        this.firstname = firstname;
        this.surname = surname;
        this.password = "";
        this.email = email;
    }
    
    // Getter and Setter methods for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
