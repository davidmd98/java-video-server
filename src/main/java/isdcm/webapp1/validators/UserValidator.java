package isdcm.webapp1.validators;

import isdcm.webapp1.model.User;
import java.util.regex.Pattern;

/**
 *
 * @author david
 */
public class UserValidator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^\\S+@\\S+\\.\\S+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");
    
    public static void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        validateUsername(user.getUsername());
        validateFirstName(user.getFirstname());
        validateSurname(user.getSurname());
        validateEmail(user.getEmail());
        validatePassword(user.getPassword());
    }
    
    private static void validateUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }
    }
    
    private static void validateFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("Firstname cannot be null or empty.");
        }
    }
    
    private static void validateSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Surname cannot be null or empty.");
        }
    }
    
    private static void validateEmail(String email) {
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException(String.format("Email cannot be null and must have a correct format. email: %s", email));
        }
    }
    
    private static void validatePassword(String password) {
        if (password == null || !PASSWORD_PATTERN.matcher(password).matches()) {
            throw new IllegalArgumentException("Password cannot be null and must have a correct format.");
        }
    }
}
