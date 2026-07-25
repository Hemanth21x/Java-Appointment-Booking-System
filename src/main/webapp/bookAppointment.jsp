<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String serviceId = request.getParameter("serviceId");

if(serviceId == null){

    response.sendRedirect("services");

    return;

}
%>

<!DOCTYPE html>

<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport"
content="width=device-width, initial-scale=1.0">

<title>Book Appointment | BookEase</title>

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

.card{

margin-top:60px;

border-radius:15px;

}

.card-header{

background:#0f2027;

color:white;

font-size:28px;

text-align:center;

font-weight:bold;

}

.btn-book{

background:#00c6ff;

color:white;

font-weight:bold;

}

.btn-book:hover{

background:#0099cc;

color:white;

}

</style>

</head>

<body>

<div class="container">

<div class="row justify-content-center">

<div class="col-md-6">

<div class="card shadow">

<div class="card-header">

<i class="fa-solid fa-calendar-check"></i>

Book Appointment

</div>

<div class="card-body">

<form action="bookAppointment" method="post">

<input
type="hidden"
name="serviceId"
value="<%= serviceId %>">

<div class="form-group">

<label>

Appointment Date

</label>

<input
type="date"
name="appointmentDate"
class="form-control"
required>

</div>

<div class="form-group">

<label>

Appointment Time

</label>

<input
type="time"
name="appointmentTime"
class="form-control"
required>

</div>

<button
type="submit"
class="btn btn-book btn-block">

Book Appointment

</button>

</form>

<br>

<a
href="services"
class="btn btn-secondary btn-block">

Back to Services

</a>

</div>

</div>

</div>

</div>

</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>