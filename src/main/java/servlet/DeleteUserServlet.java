package servlet;

import java.io.IOException;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        try {

            // Step 1: Get User ID
            int userId = Integer.parseInt(request.getParameter("id"));

            // Step 2: Create UserDAO object
            UserDAO userDAO = new UserDAO();

            // Step 3: Delete User
            boolean status = userDAO.deleteUser(userId);

            // Step 4: Print result in Eclipse Console
            System.out.println("Delete Status = " + status);

            // Step 5: Redirect to Manage Users page
            response.sendRedirect("manageUsers");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}