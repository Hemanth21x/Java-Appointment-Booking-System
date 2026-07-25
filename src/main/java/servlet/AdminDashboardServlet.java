package servlet;
import java.io.IOException;

import dao.AppointmentDAO;
import dao.ServiceDAO;
import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

@WebServlet("/adminDashboard")
public class AdminDashboardServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		
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
		
		//create Dao objects 
		
		UserDAO userDAO = new UserDAO();
		ServiceDAO serviceDAO = new ServiceDAO();
		AppointmentDAO appointmentDAO = new AppointmentDAO();
		
		//get total counts
		int totalUsers=userDAO.getTotalUsers();
		int totalServices=serviceDAO.getTotalServices();
		int totalAppointments = appointmentDAO.getTotalAppointments();
		
		//send data to jsp
		request.setAttribute("totalUsers", totalUsers);
		request.setAttribute("totalServices", totalServices);
		request.setAttribute("totalAppointments", totalAppointments);
		
		//open admin Dashboard
		
		request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);;
		
		
	}
}