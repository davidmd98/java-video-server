/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isdcm.webapp1.controller;

import isdcm.webapp1.model.Video;
import isdcm.webapp1.services.VideoApiService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.json.JsonArray;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Iñigo
 */
@WebServlet(name = "apiServlet", urlPatterns = {"/apiServlet"})
public class apiServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            request.getRequestDispatcher("jsp/searchVideo.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("isdcm.webapp1.controller.apiServlet.processRequest()");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

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
        String authorEndpoint = "http://localhost:8080/REST-video-server/resources/getByAuthor";
        String titleEndpoint = "http://localhost:8080/REST-video-server/resources/getByTitle";
        String dateEndpoint = "http://localhost:8080/REST-video-server/resources/getByCreationDate";

        VideoApiService videoApiService = new VideoApiService(authorEndpoint, titleEndpoint, dateEndpoint);

        java.lang.String title = request.getParameter("title");
        java.lang.String author = request.getParameter("author");
        java.lang.String creationDate = request.getParameter("creationDate");
        java.lang.String searchBy = request.getParameter("searchBy");

        if (searchBy.equals("title")) {
            //api title
            //videoApiService.getVideosByTitle(author);
        } else if (searchBy.equals("author")) {
            //api author
            videoApiService.getVideosByAuthor(author);
        } else if (searchBy.equals("creationDate")) {
            //api creationDate
            //videoApiService.getVideosByAuthor(author);

        } else {
            //error
        }
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
