package servlet;

import java.io.IOException;


import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

    	//Get login data 
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        //object creation
        UserDAO userDAO = new UserDAO();
        
        //verify user
        User user = userDAO.loginUser(email, password);
        
        
        //Check login
        if (user != null) {
  
            HttpSession session = request.getSession();

            session.setAttribute("user", user);
            
          if("ADMIN".equalsIgnoreCase(user.getRole())) {
            response.sendRedirect("adminDashboard.jsp");
          }else {
        	  response.sendRedirect("dashboard.jsp");
          }

        } else {

            response.sendRedirect("login.jsp");

        }
    }
}