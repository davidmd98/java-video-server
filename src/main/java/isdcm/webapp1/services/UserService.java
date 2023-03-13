package isdcm.webapp1.services;

import isdcm.webapp1.dao.UserDao;
import isdcm.webapp1.model.User;
import isdcm.webapp1.validators.UserValidator;
import isdcm.webapp1.exception.UserAlreadyExistsException;
import java.sql.SQLException;

/**
 *
 * @author david
 */
public class UserService {
    
    UserDao userDao;
    
    public UserService(UserDao userDao){
        this.userDao = userDao;
    }
    
    public void registerUser(User user, String confirmPassword) throws UserAlreadyExistsException, SQLException {
        try {
            if (userDao.exists(user.getUsername())) {
                throw new UserAlreadyExistsException();
            }
            UserValidator.validateUser(user);
            userDao.addUser(user);

        } catch (IllegalArgumentException e) {
            throw e;
        } catch (SQLException e){
            throw e;
        }
}
    
    public boolean authenticateUser(String username, String password){
        try{
            return userDao.getUserByUsernameAndPassword(username, password) != null;
        } catch (Exception e){
            return false;
        }
    }
}
