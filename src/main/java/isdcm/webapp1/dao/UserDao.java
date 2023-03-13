package isdcm.webapp1.dao;

import isdcm.webapp1.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author david
 */
public class UserDao {
    
    private Connection connection;
    
    public UserDao() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            this.connection = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/pr2;user=pr2;password=pr2");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addUser(User user) throws SQLException{
        String query = "INSERT INTO users (username, password, firstname, surname, email) VALUES (?, ?, ?, ?, ?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query);){
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstname());
            preparedStatement.setString(4, user.getSurname());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.executeUpdate();
        }
    }
    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String firstname = resultSet.getString("firstname");
                    String surname = resultSet.getString("surname");
                    String email = resultSet.getString("email");
                    return new User(username, firstname, surname, email);
                }
            }
        }

        return null;
    }
    
    public boolean exists(String username) throws SQLException{
        String query = "SELECT * FROM USERS WHERE username = ?"; 
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, username);
            return statement.executeQuery().next();
        } 
    } 
    
    public void deleteUser(String username) throws SQLException{
        String query = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.executeUpdate();
        }
    }
    
    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
