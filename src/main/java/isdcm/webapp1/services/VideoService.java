package isdcm.webapp1.services;

import isdcm.webapp1.dao.VideoDao;
import isdcm.webapp1.exception.VideoUploadException;
import isdcm.webapp1.model.Video;
import isdcm.webapp1.utils.StringToTime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import org.bytedeco.javacv.FFmpegFrameGrabber;

/**
 *
 * @author david
 */
public class VideoService {
    VideoDao videoDao;
    private final long MAX_FILE_SIZE = 1024 * 1024 * 1024;
    private final String UPLOAD_DIRECTORY = "C:\\Users\\david\\OneDrive\\Escritorio\\MEI\\1B\\ISDCM\\Lab\\java-video-server\\src\\main\\webapp\\video";
    
    public VideoService(VideoDao videoDao){
        this.videoDao = videoDao;
    }
    
    public void registerVideo(String author, String title, String description, String name, InputStream fileContent, long fileSize) 
            throws Exception, SQLException, VideoUploadException, IllegalArgumentException, IOException, ParseException{
        if (fileSize > MAX_FILE_SIZE) {
            throw new VideoUploadException("File size exceeds the limit of 1 GB!");
        }
        
        // Validate file type
        String contentType = Files.probeContentType(Paths.get(name));
        if (!contentType.startsWith("video/")) {
            throw new VideoUploadException("Only video files are allowed!");
        }
        
        String filename = System.currentTimeMillis() + "-" + name;
        String filepath = UPLOAD_DIRECTORY + File.separator + filename;
        try (OutputStream outputStream = new FileOutputStream(filepath)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileContent.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new VideoUploadException("Failed to save the video to disk!");
        }
        try{
            String duration = getVideoDuration(filepath);

            Video video = new Video(title, author, StringToTime.stringToTime(duration), description, contentType, filepath);

            videoDao.addVideo(video);
        } catch(Exception e){
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
    
    public String getVideoDuration(String filepath) throws Exception {
        FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber(filepath);
        frameGrabber.start();
        int duration = (int) Math.round(frameGrabber.getLengthInTime() / 1000000.0);
        frameGrabber.stop();

        int hours = duration / 3600;
        int minutes = (duration % 3600) / 60;
        int seconds = duration % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}

