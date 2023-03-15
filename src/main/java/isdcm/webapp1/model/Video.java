package isdcm.webapp1.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

/**
 *
 * @author david
 */
public class Video {
    private String title;
    private String author;
    private Date creationDate;
    private Time duration;
    private int reproductions;
    private String description;
    private String format;
    private String path;

    public Video(String title, String author, Date creationDate, Time duration, int reproductions, String description, String format, String path) {
        this.title = title;
        this.author = author;
        this.creationDate = creationDate;
        this.duration = duration;
        this.reproductions = reproductions;
        this.description = description;
        this.format = format;
        this.path = path;
    }
    
    public Video(String title, String author, Time duration, String description, String format, String path) {
        this.title = title;
        this.author = author;
        this.creationDate = Date.valueOf(LocalDate.now());;
        this.duration = duration;
        this.description = description;
        this.format = format;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
}
