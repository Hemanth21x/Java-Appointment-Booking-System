package servlet;

// Ends the logged-in user's session.
// Removes all session data.
// Redirects the user to the login page.

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Get the existing session (do not create a new one)
        HttpSession session = request.getSession(false);

        // If session exists, destroy it
        if (session != null) {
            session.invalidate();
        }

        // Redirect the user to the login page
        response.sendRedirect("login.jsp");
    }
}