/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isdcm.webapp1.controller;

import isdcm.webapp1.dao.VideoDao;
import isdcm.webapp1.model.Video;
import isdcm.webapp1.services.VideoService;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author david
 */
@WebServlet(name = "VideoServlet", urlPatterns = {"/VideoServlet"})
public class VideoServlet extends HttpServlet {
    
    VideoDao videoDao = new VideoDao();
    VideoService videoService = new VideoService(videoDao);
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String currentUser = (String) request.getSession().getAttribute("currentUser");
            String title = request.getParameter("title");
            Time duration = stringToTime(request.getParameter("duration"));
            String description = request.getParameter("description");
            String format = request.getParameter("format");
            if (currentUser == null) {
                response.sendRedirect("login.jsp");
            }
            
            Video video = new Video(
                    title,
                    currentUser,
                    duration,
                    description,
                    format, 
                    "path"
            );
            
            videoService.registerVideo(video);
            response.sendRedirect("profile.jsp");
            response.setStatus(HttpServletResponse.SC_OK);
            
        } 
        catch (Exception e)
        {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            System.err.println("Unexpected error ocurred: " + e);
        }   
    }
    
    public Time stringToTime(String timeStr) throws ParseException {
        if (timeStr == null || timeStr.trim().isEmpty()) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        java.util.Date date = sdf.parse(timeStr);
        return new java.sql.Time(date.getTime());
    }
}
