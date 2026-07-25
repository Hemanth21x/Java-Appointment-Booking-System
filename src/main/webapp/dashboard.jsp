<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.User" %>

<%
    User user = (User) session.getAttribute("user");

    if(user == null){

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

<title>Dashboard | BookEase</title>

<!-- Google Font -->

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
rel="stylesheet">

<!-- Bootstrap -->

<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- Font Awesome -->

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<style>

*{

margin:0;
padding:0;
box-sizing:border-box;

}

body{

font-family:'Poppins',sans-serif;

background:#f5f7fb;

}

/* Navbar */

.navbar{

background:#0f2027;

padding:15px 8%;

}

.navbar-brand{

color:white!important;

font-size:28px;

font-weight:bold;

}

.nav-link{

color:white!important;

margin-left:20px;

font-weight:500;

}

.nav-link:hover{

color:#00e5ff!important;

}

/* Dashboard */

.dashboard{

padding:70px 0;

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

footer{

background:#0f2027;

color:white;

text-align:center;

padding:20px;

margin-top:60px;

}

</style>

</head>

<body>

<!-- Navbar -->

<nav class="navbar navbar-expand-lg">

<a class="navbar-brand"
href="dashboard.jsp">

<i class="fa-solid fa-calendar-check"></i>

BookEase

</a>

<div class="collapse navbar-collapse">

<ul class="navbar-nav ml-auto">

<li class="nav-item">

<a class="nav-link"
href="services">

Services

</a>

</li>

<li class="nav-item">

<a class="nav-link"
href="appointments">

My Appointments

</a>

</li>

<li class="nav-item">

<a class="nav-link"
href="logout">

Logout

</a>

</li>

</ul>

</div>

</nav>

<!-- Welcome -->

<div class="container dashboard">

<div class="text-center mb-5">

<h2>

Welcome,

<%= user.getName() %>

</h2>

<p>

Manage your appointments quickly and easily.

</p>

</div>

<div class="row">

<div class="col-md-4">

<div class="card shadow text-center p-4">

<i class="fa-solid fa-list fa-3x"></i>

<h4 class="mt-3">

Services

</h4>

<p>

View all available services.

</p>

<a href="services"
class="btn btn-primary">

View Services

</a>

</div>

</div>

<div class="col-md-4">

<div class="card shadow text-center p-4">

<i class="fa-solid fa-calendar-days fa-3x"></i>

<h4 class="mt-3">

Appointments

</h4>

<p>

View your booked appointments.

</p>

<a href="appointments"
class="btn btn-success">

My Appointments

</a>

</div>

</div>

<div class="col-md-4">

<div class="card shadow text-center p-4">

<i class="fa-solid fa-right-from-bracket fa-3x"></i>

<h4 class="mt-3">

Logout

</h4>

<p>

End your current session.

</p>

<a href="logout"
class="btn btn-danger">

Logout

</a>

</div>

</div>

</div>

</div>

<footer>

<p>

© 2026 BookEase | Appointment Booking System

</p>

</footer>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>