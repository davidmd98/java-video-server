/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isdcm.webapp1.controller;

import isdcm.webapp1.exception.UserAlreadyExistsException;
import isdcm.webapp1.model.User;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author david
 */
@WebServlet(name = "UsersServlet", urlPatterns = {"/UsersServlet"})
public class UserServlet extends HttpServlet {
    
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
        try{
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            response.setContentType("text/html;charset=UTF-8");
            
            if (User.checkPassword(username, password)){
                request.getSession().setAttribute("currentUser", username);
                response.sendRedirect("profile.jsp");
            }
            else response.sendRedirect("signin.jsp");
        }catch (Exception e)
        {
            
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            System.err.println("Unexpected error ocurred: " + e);
        }   
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
        
        try {
            if(singin(request)){
                request.getSession().setAttribute("currentUser", request.getParameter("username"));
                response.sendRedirect("profile.jsp");
            }
            response.setStatus(HttpServletResponse.SC_OK);
            
        } 
        catch (UserAlreadyExistsException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            System.err.println("User already exists");
        }
        catch (Exception e)
        {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            System.err.println("Unexpected error ocurred: " + e);
        }    
        
    }
 
    
    private static boolean singin(HttpServletRequest request) throws UserAlreadyExistsException, MalformedURLException, SQLException, ClassNotFoundException{
        
        String username = request.getParameter("username");
        
        if (User.exists(username)){
            throw new UserAlreadyExistsException();
        }
        
        User.insertUser(request.getParameter("username"),
                request.getParameter("firstname"),
                request.getParameter("surname"),
                request.getParameter("email"),
                request.getParameter("password")
        );    
        
        return true;
    }
}
