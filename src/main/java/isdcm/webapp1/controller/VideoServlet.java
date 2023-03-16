package isdcm.webapp1.controller;

import isdcm.webapp1.dao.VideoDao;
import isdcm.webapp1.model.Video;
import isdcm.webapp1.services.VideoService;
import isdcm.webapp1.utils.StringToTime;
import java.io.IOException;
import java.sql.Time;
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
            Time duration = StringToTime.stringToTime(request.getParameter("duration"));
            String description = request.getParameter("description");
            String format = request.getParameter("format");
            
            if (currentUser == null) {
                response.sendRedirect("login.jsp");
                System.out.println("user is null");
            }
            
            Video video = new Video(
                    title,
                    currentUser,
                    duration,
                    description,
                    format, 
                    "path"
            );
            System.out.println(String.format("title: %s, currentUser: %s, duration: %s, description: %s, format: %s", title,
                    currentUser,
                    duration,
                    description,
                    format));
            videoService.registerVideo(video);
            response.sendRedirect("profile.jsp");
            response.setStatus(HttpServletResponse.SC_OK);
            
        } 
        catch(IllegalArgumentException e){
            request.setAttribute("errorMessage", e);
            request.getRequestDispatcher("registerVideo.jsp").forward(request, response);
        }
        catch (Exception e)
        {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            System.err.println("Unexpected error ocurred: " + e);
        }   
    } 
}
