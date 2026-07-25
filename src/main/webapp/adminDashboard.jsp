<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
if(session.getAttribute("user") == null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<%@ page import="model.User" %>

<%
User user = (User) session.getAttribute("user");

if (user == null || !"ADMIN".equalsIgnoreCase(user.getRole())) {
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Admin Dashboard | BookEase</title>

<link
href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
rel="stylesheet">

<link
rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<style>

body{

background:#f4f6f9;

}

.card{

transition:0.3s;

}

.card:hover{

transform:scale(1.03);

}

</style>

</head>

<body>

<div class="container mt-5">

<h2 class="text-center mb-5">

<i class="fas fa-user-shield"></i>

BookEase Admin Dashboard

</h2>

<div class="row">

<div class="col-md-4">

<div class="card text-center shadow">

<div class="card-body">

<h3>👥</h3>

<h4>Total Users</h4>

<h2>${totalUsers}</h2>

</div>

</div>

</div>

<div class="col-md-4">

<div class="card text-center shadow">

<div class="card-body">

<h3>🛠</h3>

<h4>Total Services</h4>

<h2>${totalServices}</h2>

</div>

</div>

</div>

<div class="col-md-4">

<div class="card text-center shadow">

<div class="card-body">

<h3>📅</h3>

<h4>Total Appointments</h4>

<h2>${totalAppointments}</h2>

</div>

</div>

</div>

</div>

<div class="text-center mt-5">

<a href="manageUsers"
class="btn btn-primary m-2">

Manage Users

</a>

<a href="manageServices"
class="btn btn-success m-2">

Manage Services

</a>

<a href="manageAppointments"
class="btn btn-warning m-2">

Manage Appointments

</a>

<a href="logout"
class="btn btn-danger m-2">

Logout

</a>

</div>

</div>

</body>

</html>