package model;

import java.sql.Date;
import java.sql.Time;

public class Appointment {

    private int appointmentId;
    private int userId;
    private int serviceId;
    private Date appointmentDate;
    private Time appointmentTime;
    private String status;

    // Default Constructor
    public Appointment() {

    }

    // Parameterized Constructor (Without appointmentId)
    public Appointment(int userId, int serviceId,
                       Date appointmentDate,
                       Time appointmentTime,
                       String status) {

        this.userId = userId;
        this.serviceId = serviceId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }

    // Parameterized Constructor (With appointmentId)
    public Appointment(int appointmentId,
                       int userId,
                       int serviceId,
                       Date appointmentDate,
                       Time appointmentTime,
                       String status) {

        this.appointmentId = appointmentId;
        this.userId = userId;
        this.serviceId = serviceId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Time getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Time appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}