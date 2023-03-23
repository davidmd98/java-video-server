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
    private int reproductions;
    private String description;
    private boolean isLocal;
    private String url;

    public Video(String title, String author, Date creationDate, String description, String url, boolean isLocal) {
        this.title = title;
        this.author = author;
        this.creationDate = creationDate;
        this.reproductions = 0;
        this.description = description;
        this.url = url;
        this.isLocal = isLocal;
    }
    
    public Video(String title, String author, Date creationDate, int reproductions, String description, String url, boolean isLocal) {
        this.title = title;
        this.author = author;
        this.creationDate = creationDate;
        this.reproductions = reproductions;
        this.description = description;
        this.url = url;
        this.isLocal = isLocal;
    }
    
    public Video(String title, String author, String description, String url, boolean isLocal) {
        this.title = title;
        this.author = author;
        this.creationDate = new Date(System.currentTimeMillis());
        this.reproductions = 0;
        this.description = description;
        this.url = url;
        this.isLocal = isLocal;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;

    }

    public boolean getIsLocal() {
        return isLocal;
    }

    public void setIsLocal(boolean isLocal) {
        this.isLocal = isLocal;
    }
}
