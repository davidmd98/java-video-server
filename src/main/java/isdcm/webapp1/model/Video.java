/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isdcm.webapp1.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
public class Video {
    private int id;
    private String title;
    private String author;
    private Date creationDate;
    private Time duration;
    private int reproductions;
    private String description;
    private String format;

    public Video(int id, String title, String author, Date creationDate, Time duration, int reproductions, String description, String format) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.creationDate = creationDate;
        this.duration = duration;
        this.reproductions = reproductions;
        this.description = description;
        this.format = format;
    }

    // Getter and Setter methods for each field

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public int getReproductions() {
        return reproductions;
    }

    public void setReproductions(int reproductions) {
        this.reproductions = reproductions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
    
    public static boolean registerVideo(String author, String title, String duration, String description, String format) 
            throws ClassNotFoundException, SQLException{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/pr2;user=pr2;password=pr2"); 
        
        PreparedStatement preparedStatement = c.prepareStatement("INSERT INTO videos (title, author, creation_date, duration, description, format) VALUES (?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, author);
        preparedStatement.setDate(3, new Date(System.currentTimeMillis()));
        preparedStatement.setString(4, duration);
        preparedStatement.setString(5, description);
        preparedStatement.setString(6, format);
        preparedStatement.executeUpdate();

        return true;
    }
    
    public static List<Video> getVideosByAuthor(String currentUser)
            throws ClassNotFoundException, SQLException{
        List<Video> videos = new ArrayList<>();
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/pr2;user=pr2;password=pr2");
        PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM VIDEOS WHERE author = ?");
        preparedStatement.setString(1, currentUser);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            Date creationDate = resultSet.getDate("creation_date");
            Time duration = resultSet.getTime("duration");
            int reproductions = resultSet.getInt("reproductions");
            String description = resultSet.getString("description");
            String format = resultSet.getString("format");
            Video video = new Video(id, title, currentUser, creationDate, duration, reproductions, description, format);
            videos.add(video);
        }
        return videos;
    }
}
