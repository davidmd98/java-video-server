/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isdcm.webapp1.controller;

import isdcm.webapp1.services.VideoApiService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Iñigo
 */
@WebServlet(name = "ApiServlet", urlPatterns = {"/ApiServlet"})
public class ApiServlet extends HttpServlet {
    
    VideoApiService videoApiService = new VideoApiService();

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String searchBy = request.getParameter("searchBy");

        switch (searchBy) {
            case "title": 
                String title = request.getParameter("title");
                break;
            case "author": 
                String author = request.getParameter("author");
                break;
            case "creationDate": 
                String creationDate = request.getParameter("creationDate");
                break;
            default:
                break;
        } 
        
        response.setContentType("text/html;charset=UTF-8");
        try {
            request.getRequestDispatcher("searchVideo.jsp").forward(request, response);
        } catch (Exception e) {
            throw e;
        }
    }

}
