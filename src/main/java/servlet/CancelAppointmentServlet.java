package servlet;

import java.io.IOException;

import dao.AppointmentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cancelAppointment")
public class CancelAppointmentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
throws ServletException, IOException {
    	
    	//Get appointment id 
    	int appointmentid = Integer.parseInt(request.getParameter("id"));
    	
    	
    	//create appointment dao object 
    	AppointmentDAO appointmentDAO = new AppointmentDAO ();
    	
    	//cancel appoinment
    	appointmentDAO.cancelAppointment(appointmentid);
    	
    	
    	//redirect back to my Appointments
    	
    	response.sendRedirect("appointments");
    	
    }
}
