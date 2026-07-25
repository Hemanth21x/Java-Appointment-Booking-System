package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import dao.AppointmentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Appointment;
import model.User;

@WebServlet("/bookAppointment")
public class BookAppointmentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Step 1: Get logged-in user
        HttpSession session = request.getSession(false);

        User user = (User) session.getAttribute("user");
        System.out.println("Booking User ID = " + user.getUserId());

        // Step 2: Read form data
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));

        Date appointmentDate =
                Date.valueOf(request.getParameter("appointmentDate"));

        Time appointmentTime =
                Time.valueOf(request.getParameter("appointmentTime") + ":00");

        // Step 3: Create Appointment object
        Appointment appointment = new Appointment();

        appointment.setUserId(user.getUserId());
        appointment.setServiceId(serviceId);
        appointment.setAppointmentDate(appointmentDate);
        appointment.setAppointmentTime(appointmentTime);

        // Step 4: Call DAO
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        boolean status =
                appointmentDAO.bookAppointment(appointment);

        // Step 5: Redirect
        if (status) {

            response.sendRedirect("appointments");

        } else {

            response.sendRedirect("bookAppointment.jsp");
        }

    }

}