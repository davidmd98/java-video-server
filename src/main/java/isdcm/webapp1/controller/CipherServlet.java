/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isdcm.webapp1.controller;

import isdcm.webapp1.services.CipherService;
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
@WebServlet(name = "CipherServlet", urlPatterns = {"/CipherServlet"})
public class CipherServlet extends HttpServlet {

    private CipherService cipherService = new CipherService();
    /**
     * Processes requests for both HTTP <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cipherOption = request.getParameter("cipherOption");
        String inputFile = request.getParameter("inputFile");
        String outputFile = request.getParameter("outputFile");
        System.out.println("CipherOptio: " + cipherOption);
        try{
            switch(cipherOption){
            case "cipher":
                cipherService.cipher(inputFile, outputFile);
                break;
            case "decipher":
                cipherService.decipher(inputFile, outputFile);
                break;
            }
        } catch(Exception e){
            System.out.println("Erroooooor!");
        }
        
    }

}
