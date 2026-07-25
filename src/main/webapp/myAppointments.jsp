<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="model.Appointment" %>

<%
@SuppressWarnings("unchecked")
List<Appointment> appointments =
(List<Appointment>) request.getAttribute("appointments");
%>

<%@ page import="model.User" %>

<%
User user = (User) session.getAttribute("user");

if (user == null) {
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport"
content="width=device-width, initial-scale=1.0">

<title>My Appointments | BookEase</title>

<!-- Bootstrap -->

<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- Font Awesome -->

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<style>

body{

background:#f5f7fb;

font-family:Arial,sans-serif;

}

h2{

font-weight:bold;

margin-bottom:30px;

}

.table{

background:white;

}

.btn-dashboard{

margin-top:20px;

}

</style>

</head>

<body>

<div class="container mt-5">

<h2 class="text-center">

<i class="fa-solid fa-calendar-check"></i>

My Appointments

</h2>

<table class="table table-bordered table-hover">

<thead class="thead-dark">

<tr>

<th>Appointment ID</th>

<th>Service ID</th>

<th>Date</th>

<th>Time</th>

<th>Status</th>

<th>Action</th>

</tr>

</thead>

<tbody>

<%

if(appointments != null && !appointments.isEmpty()){

for(Appointment appointment : appointments){

%>

<tr>

<td>

<%= appointment.getAppointmentId() %>

</td>

<td>

<%= appointment.getServiceId() %>

</td>

<td>

<%= appointment.getAppointmentDate() %>

</td>

<td>

<%= appointment.getAppointmentTime() %>

</td>

<td>

<%= appointment.getStatus() %>

</td>

<td>

<%
if("PENDING".equals(appointment.getStatus())){
%>

<a href="cancelAppointment?id=<%= appointment.getAppointmentId() %>"
   class="btn btn-danger btn-sm"
   onclick="return confirm('Are you sure you want to cancel this appointment?');">

    Cancel

</a>

<%
}else{
%>

<span class="text-success">Cancelled</span>

<%
}
%>

</td>

</tr>

<%

}

}else{

%>

<tr>

<td colspan="6" class="text-center">

No Appointments Found

</td>

</tr>

<%

}

%>

</tbody>

</table>

<div class="text-center">

<a
href="dashboard.jsp"
class="btn btn-primary btn-dashboard">

Back to Dashboard

</a>

</div>

</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>