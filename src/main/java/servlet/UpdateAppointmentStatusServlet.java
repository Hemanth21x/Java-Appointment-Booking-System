package servlet;

import java.io.IOException;

import dao.AppointmentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateAppointmentStatus")
public class UpdateAppointmentStatusServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Step 1: Get appointment ID
        int appointmentId = Integer.parseInt(request.getParameter("id"));

        // Step 2: Get new status
        String status = request.getParameter("status");

        // Step 3: Create DAO object
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        // Step 4: Update appointment status
        appointmentDAO.updateAppointmentStatus(appointmentId, status);

        // Step 5: Redirect back to Manage Appointments
        response.sendRedirect("manageAppointments");
    }
}