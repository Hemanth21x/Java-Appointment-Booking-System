<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="model.Appointment" %>

<%
@SuppressWarnings("unchecked")
List<Appointment> appointments =
(List<Appointment>) request.getAttribute("appointments");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Manage Appointments | BookEase</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
rel="stylesheet">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

</head>

<body class="bg-light">

<div class="container mt-5">

<h2 class="text-center mb-4">

<i class="fas fa-calendar-check"></i>

Manage Appointments

</h2>

<table class="table table-bordered table-hover">

<thead class="table-dark">

<tr>

<th>ID</th>
<th>User ID</th>
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

<td><%= appointment.getAppointmentId() %></td>

<td><%= appointment.getUserId() %></td>

<td><%= appointment.getServiceId() %></td>

<td><%= appointment.getAppointmentDate() %></td>

<td><%= appointment.getAppointmentTime() %></td>

<td>

<span class="badge bg-primary">

<%= appointment.getStatus() %>

</span>

</td>

<td>

<a href="updateAppointmentStatus?id=<%= appointment.getAppointmentId() %>&status=CONFIRMED"
class="btn btn-success btn-sm">

Confirm

</a>

<a href="updateAppointmentStatus?id=<%= appointment.getAppointmentId() %>&status=CANCELLED"
class="btn btn-danger btn-sm">

Cancel

</a>

</td>

</tr>

<%

}

}else{

%>

<tr>

<td colspan="7" class="text-center">

No Appointments Found

</td>

</tr>

<%

}

%>

</tbody>

</table>

<div class="text-center">

<a href="adminDashboard"
class="btn btn-primary">

Back to Dashboard

</a>

</div>

</div>

</body>
</html>