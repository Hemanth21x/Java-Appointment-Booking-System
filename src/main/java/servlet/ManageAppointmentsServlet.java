package servlet;

import java.io.IOException;
import java.util.List;

import dao.AppointmentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Appointment;
import model.User;

@WebServlet("/manageAppointments")
public class ManageAppointmentsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
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
    	
        // Step 1: Create AppointmentDAO object
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        // Step 2: Get all appointments
        List<Appointment> appointments = appointmentDAO.getAllAppointments();

        // Step 3: Store list in request
        request.setAttribute("appointments", appointments);

        // Step 4: Forward to JSP
        request.getRequestDispatcher("manageAppointments.jsp")
               .forward(request, response);
    }
}