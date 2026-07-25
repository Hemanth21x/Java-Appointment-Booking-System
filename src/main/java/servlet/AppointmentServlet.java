package servlet;

//Gets all appointments of the logged-in user.
//Calls AppointmentDAO.getAppointmentsByUser().
//Sends the appointment list to myAppointments.jsp.

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

@WebServlet("/appointments")
public class AppointmentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Step 1: Get current session
        HttpSession session = request.getSession(false);
        System.out.println("Session = " + session);

        // Check if session exists
        if (session == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Step 2: Get logged-in user
        User user = (User) session.getAttribute("user");
        System.out.println("User = " + user);

        // Check if user is logged in
        if (user == null) {
        	 System.out.println("User is NULL");
            response.sendRedirect("login.jsp");
            return;
        }

        // Step 3: Create DAO object
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        // Step 4: Get appointments
        List<Appointment> appointments =
                appointmentDAO.getAppointmentsByUser(user.getUserId());

        // Step 5: Send data to JSP
        request.setAttribute("appointments", appointments);

        // Step 6: Forward to JSP
        request.getRequestDispatcher("myAppointments.jsp")
               .forward(request, response);
    }
}