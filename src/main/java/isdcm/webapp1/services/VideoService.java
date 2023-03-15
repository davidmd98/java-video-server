package isdcm.webapp1.services;

import isdcm.webapp1.dao.VideoDao;
import isdcm.webapp1.model.Video;
import isdcm.webapp1.validators.VideoValidator;
import java.sql.SQLException;
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
    
    public void registerVideo(Video video) throws SQLException, IllegalArgumentException{
        try{
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
