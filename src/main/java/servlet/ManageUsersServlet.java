package servlet;

import java.io.IOException;
import java.util.List;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

@WebServlet("/manageUsers")
public class ManageUsersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);

		if (session == null) {
		    response.sendRedirect("login.jsp");
		    return;
		}

		User user = (User) session.getAttribute("user");

		if (user == null || !"ADMIN".equalsIgnoreCase(user.getRole())) {
		    response.sendRedirect("login.jsp");
		    return;
		}

		// create user object
		UserDAO userDAO = new UserDAO();

		// get all users
		List<User> users = userDAO.getAllUsers();

		// Send list to JSP
		request.setAttribute("users", users);

		// Open manageUsers.jsp
		request.getRequestDispatcher("manageUsers.jsp").forward(request, response);
	}

}