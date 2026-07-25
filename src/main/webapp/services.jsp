<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="model.Service"%>

<%
List<Service> services =
(List<Service>)request.getAttribute("services");
%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport"
content="width=device-width, initial-scale=1.0">

<title>Services | BookEase</title>

<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<style>

body{

background:#f5f7fb;

font-family:Arial,sans-serif;

}

.card{

border:none;

border-radius:15px;

transition:.3s;

}

.card:hover{

transform:translateY(-8px);

}

.card i{

color:#00c6ff;

}

</style>

</head>

<body>

<div class="container mt-5">

<h2 class="text-center mb-4">

Available Services

</h2>

<div class="row">

<%

if(services != null){

for(Service service : services){

%>

<div class="col-md-4 mb-4">

<div class="card shadow">

<div class="card-body text-center">

<i class="fa-solid fa-calendar-check fa-3x"></i>

<h4 class="mt-3">

<%= service.getName() %>

</h4>

<p>

Duration :
<%= service.getDurationMinutes() %>
Minutes

</p>

<p>

Price :
₹ <%= service.getPrice() %>

</p>

<a href="bookAppointment.jsp?serviceId=<%= service.getServiceId() %>"
class="btn btn-primary">

Book Appointment

</a>

</div>

</div>

</div>

<%

}

}

%>

</div>

<div class="text-center mt-4">

<a href="dashboard.jsp"
class="btn btn-secondary">

Back to Dashboard

</a>

</div>

</div>

</body>

</html>