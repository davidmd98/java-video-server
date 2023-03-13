/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isdcm.webapp1.services;

import isdcm.webapp1.dao.VideoDao;
import isdcm.webapp1.model.Video;
import isdcm.webapp1.validators.VideoValidator;
import java.util.ArrayList;
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
    
    public boolean registerVideo(Video video) {
        try{
            VideoValidator.validateVideo(video);
            videoDao.addVideo(video);
        } catch(Exception e){
            return false;
        }
        
        return true;
    }
    
    public List<Video> getVideosByAuthor(String currentUser){
        List<Video> videos; 
        try{
            videos = new ArrayList<>();
            return videos;
        
        } catch(Exception e){
            return null;
        }
        
    }
}
