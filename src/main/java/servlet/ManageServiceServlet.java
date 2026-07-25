package servlet;

import java.io.IOException;
import java.util.List;

import dao.ServiceDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Service;
import model.User;

@WebServlet("/manageServices")
public class ManageServiceServlet extends HttpServlet {

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

		// Create DAO object
		ServiceDAO serviceDAO = new ServiceDAO();

		// get all services
		List<Service> services = serviceDAO.getAllServices();

		// Send list to JSP
		request.setAttribute("services", services);

		// Open JSP
		request.getRequestDispatcher("manageServices.jsp").forward(request, response);

	}

}