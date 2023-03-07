/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isdcm.webapp1.controller;

import isdcm.webapp1.model.Video;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
            if (currentUser == null) {
                response.sendRedirect("login.jsp");
            }
            Video.registerVideo(currentUser,
                    request.getParameter("title"),
                    request.getParameter("duration"),
                    request.getParameter("description"),
                    request.getParameter("format"));
            response.sendRedirect("profile.jsp");
            response.setStatus(HttpServletResponse.SC_OK);
            
        } 
        catch (Exception e)
        {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            System.err.println("Unexpected error ocurred: " + e);
        }   
    }
}
