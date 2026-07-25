# Appointment Booking System

A web-based Appointment Booking System developed using Java JSP and Servlet.  
This project allows users to book appointments for different services and allows administrators to manage users, services, and appointments.

## 🚀 Technologies Used

- Java
- JSP (Java Server Pages)
- Servlets
- JDBC
- MySQL
- HTML
- CSS
- Bootstrap
- Apache Tomcat Server
- Eclipse IDE

## 📌 Project Features

## User Module

- User Registration
- User Login
- User Logout
- View Available Services
- View Service Details
- Book Appointment
- View My Appointments
- Cancel Appointment


## Admin Module

- Admin Login
- Admin Dashboard
- Manage Users
- View All Users
- Delete Users
- Manage Services
- Add New Services
- Edit Services
- Delete Services
- View All Appointments
- Update Appointment Status


## 🗄️ Database Details

Database Name:

### Tables

### Users Table

Stores user account information:

- user_id
- name
- email
- password
- role


### Services Table

Stores available services:

- service_id
- name
- description
- duration_minutes
- price


### Appointments Table

Stores booking details:

- appointment_id
- user_id
- service_id
- appointment_date
- appointment_time
- status


## 🏗️ Project Architecture

This project follows MVC architecture.

### Model

Contains Java classes for data representation:

- User.java
- Service.java
- Appointment.java


### View

User interface pages developed using:

- JSP
- HTML
- Bootstrap


### Controller

Handles user requests using:

- Servlets


### DAO Layer

Handles database operations:

- UserDAO
- ServiceDAO
- AppointmentDAO


## 🔄 Application Flow

### User Flow

Register → Login → View Services → Select Service → Book Appointment → View Appointment → Cancel Appointment


### Admin Flow

Admin Login → Dashboard → Manage Users → Manage Services → Manage Appointments


## ⚙️ How to Run the Project

1. Install Java JDK
2. Install Eclipse IDE
3. Configure Apache Tomcat Server
4. Create MySQL database named `booking_system`
5. Import the project into Eclipse
6. Update database connection details
7. Run the project on Tomcat Server


## 🎯 Future Enhancements

- Online payment integration
- Email notifications
- User profile management
- Appointment reminders
- Password encryption
- Better UI improvements


## 👨‍💻 Developer

Developed as a Java Full Stack Web Application Project.


## 📄 Conclusion

The Appointment Booking System provides an efficient platform for users to schedule appointments online and helps administrators manage users, services, and bookings easily.
