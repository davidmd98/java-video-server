package isdcm.webapp1.controller;

import isdcm.webapp1.dao.UserDao;
import isdcm.webapp1.exception.UserAlreadyExistsException;
import isdcm.webapp1.model.User;
import isdcm.webapp1.services.UserService;
import java.io.IOException;
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
    
    private UserDao userDao = new UserDao();
    private UserService userService = new UserService(userDao);

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
            String action = request.getParameter("action");
            
            if(action.equals("login")){
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                if (userService.authenticateUser(username, password)){
                    request.getSession().setAttribute("currentUser", username);
                    response.sendRedirect("profile.jsp");
                }
                else {
                    String errorMessage = "Username or password is not correct.";
                    request.setAttribute("errorMessage", errorMessage);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } else if(action.equals("logout")){
                request.getSession().invalidate();
                response.sendRedirect("login.jsp");
            }
            
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
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String confirmPassword = request.getParameter("confirmPassword");
        if(!password.equals(confirmPassword)){
            String errorMessage = "Password does not match the confirmation.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("signin.jsp").forward(request, response);
        }
        else{
            User user = new User(username, firstname, surname, password, email);
        
            try {
                userService.registerUser(user, confirmPassword);
                request.getSession().setAttribute("currentUser", request.getParameter("username"));
                response.sendRedirect("profile.jsp");
                response.setStatus(HttpServletResponse.SC_OK);       
            } 
            catch(UserAlreadyExistsException e){
                String errorMessage = "User already exists.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("signin.jsp").forward(request, response);
            }
            catch(IllegalArgumentException e){
                String errorMessage = e.getMessage();
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("signin.jsp").forward(request, response);
            }
            catch (Exception e)
            {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                System.err.println("Unexpected error ocurred: " + e);
            }  
        }
          
        
    }
}
