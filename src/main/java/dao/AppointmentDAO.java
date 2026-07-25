package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Appointment;
import util.DBConnection;

//bookAppointment(Appointment appointment)
//Inserts a new appointment into the appointments table.
//Returns true if the appointment is booked successfully.
//getAppointmentsByUser(int userId)
//Retrieves all appointments for a specific user.
//Returns a List<Appointment>.
//cancelAppointment(int appointmentId)
//Updates the appointment status to CANCELLED.
//Returns true if the update is successful.

public class AppointmentDAO {

    // Book Appointment
    public boolean bookAppointment(Appointment appointment) {

        boolean status = false;

        String sql = "INSERT INTO appointments(user_id, service_id, appointment_date, appointment_time) VALUES (?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, appointment.getUserId());
            ps.setInt(2, appointment.getServiceId());
            ps.setDate(3, appointment.getAppointmentDate());
            ps.setTime(4, appointment.getAppointmentTime());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // Get Appointments By User
    public List<Appointment> getAppointmentsByUser(int userId) {

        List<Appointment> appointments = new ArrayList<>();

        String sql = "SELECT * FROM appointments WHERE user_id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Appointment appointment = new Appointment();

                appointment.setAppointmentId(rs.getInt("appointments_id"));
                appointment.setUserId(rs.getInt("user_id"));
                appointment.setServiceId(rs.getInt("service_id"));
                appointment.setAppointmentDate(rs.getDate("appointment_date"));
                appointment.setAppointmentTime(rs.getTime("appointment_time"));
                appointment.setStatus(rs.getString("status"));

                appointments.add(appointment);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return appointments;
    }

    // Cancel Appointment
    public boolean cancelAppointment(int appointmentId) {

        boolean status = false;

        String sql = "UPDATE appointments SET status = 'CANCELLED' WHERE appointments_id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, appointmentId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
               status  = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    
    //get Total appointments
    
    public int getTotalAppointments() {
    	
    	int totalAppointments=0;
    	
    	String sql ="select count(*)from appointments";
    	
    	try {
    		Connection conn= DBConnection.getConnection();
    		
    		PreparedStatement ps = conn.prepareStatement(sql);
    		
    	    ResultSet rs = ps.executeQuery();
    	    
    	    if(rs.next()) {
    	    	totalAppointments=rs.getInt(1);
    	    }
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return totalAppointments;
    }
 // Get All Appointments
    public List<Appointment> getAllAppointments() {

        List<Appointment> appointments = new ArrayList<>();

        String sql = "SELECT * FROM appointments";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Appointment appointment = new Appointment();

                appointment.setAppointmentId(rs.getInt("appointments_id"));
                appointment.setUserId(rs.getInt("user_id"));
                appointment.setServiceId(rs.getInt("service_id"));
                appointment.setAppointmentDate(rs.getDate("appointment_date"));
                appointment.setAppointmentTime(rs.getTime("appointment_time"));
                appointment.setStatus(rs.getString("status"));

                appointments.add(appointment);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return appointments;
    }
    
 // Update Appointment Status
    public boolean updateAppointmentStatus(int appointmentId, String status) {

        boolean result = false;

        String sql = "UPDATE appointments SET status = ? WHERE appointments_id = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, status);
            ps.setInt(2, appointmentId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}