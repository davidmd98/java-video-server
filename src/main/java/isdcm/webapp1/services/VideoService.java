package isdcm.webapp1.services;

import isdcm.webapp1.dao.VideoDao;
import isdcm.webapp1.model.Video;
import isdcm.webapp1.utils.StringToTime;
import isdcm.webapp1.validators.VideoValidator;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author david
 */
public class VideoService {
    VideoDao videoDao;
    
    public VideoService(VideoDao videoDao){
        this.videoDao = videoDao;
    }
    
    public void registerVideo(String author, String title, String description, String url) 
            throws SQLException, IllegalArgumentException, ParseException{
        try{
            Video video = new Video(title, author, description, url, true);
            VideoValidator.validateVideo(video);
            videoDao.addVideo(video);
        } catch(IllegalArgumentException e){
            throw e;
        } catch(SQLException e){
            throw e;
        } 
    }
    
    public List<Video> getVideosByAuthor(String currentUser) {
        try{
            return videoDao.getVideosByAuthor(currentUser);
        
        } catch(Exception e){
            return null;
        }
        
    }
    
    public List<Video> getVideos(){
        try{
            return videoDao.getVideos();
        }catch(Exception e){
            return null;
        }
    }
}

