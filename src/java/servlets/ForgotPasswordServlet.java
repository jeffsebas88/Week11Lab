/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import businesslogic.AccountService;
import dataaccess.NotesDBException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 643507
 */
public class ForgotPasswordServlet extends HttpServlet {

  
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  String emailUsed  = request.getParameter("emailUsed");
        String path = getServletContext().getRealPath("/WEB-INF/emailtemplates/login.html");
     
        
        AccountService as = new AccountService();
       boolean emails;
        try {
            emails = as.forgotPassword(emailUsed, path);
               if(emails){
           request.setAttribute("emailStatus", "Password sent to the email: " + emailUsed);
       }
       else {
           request.setAttribute("emailStatus", "Invalid account, email was not sent");
       }
        } catch (NotesDBException ex) {
            Logger.getLogger(ForgotPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
    
}
  

}
