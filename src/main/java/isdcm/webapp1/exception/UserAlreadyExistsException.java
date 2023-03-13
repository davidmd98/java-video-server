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