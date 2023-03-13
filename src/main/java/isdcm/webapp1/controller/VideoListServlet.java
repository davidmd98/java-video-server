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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author david
 */
@WebServlet(name = "VideoListServlet", urlPatterns = {"/VideoListServlet"})
public class VideoListServlet extends HttpServlet {
    VideoDao videoDao = new VideoDao();
    VideoService videoService = new VideoService(videoDao);
    /**
     * Processes requests for both HTTP <code>GET</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String currentUser = (String) request.getSession().getAttribute("currentUser");
        if (currentUser == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        try {
            List<Video> videos = videoService.getVideosByAuthor(currentUser);
            request.setAttribute("videos", videos);
            request.getRequestDispatcher("videoList.jsp").forward(request, response);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            System.err.println("Unexpected error occurred: " + e);
        }
    }

    

}
