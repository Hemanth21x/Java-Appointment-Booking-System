<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<!--  Purpose (3 lines)
Home page of the application.
Displays welcome message.
Provides Register and Login buttons.
-->

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>BookEase | Appointment Booking System</title>


<!-- Google Font -->
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">


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

padding:18px 8%;

background:#0f2027;

}


.navbar-brand{

font-size:28px;

font-weight:700;

color:white!important;

}


.navbar-brand i{

color:#00e5ff;

margin-right:10px;

}


.nav-link{

color:white!important;

margin-left:25px;

font-weight:500;

}


.nav-link:hover{

color:#00e5ff!important;

}



/* Hero */


.hero{

min-height:90vh;

display:flex;

align-items:center;

background:
linear-gradient(135deg,#0f2027,#203a43,#2c5364);

color:white;

}


.hero h1{

font-size:55px;

font-weight:700;

}


.hero h1 span{

color:#00e5ff;

}


.hero p{

margin-top:20px;

font-size:18px;

line-height:1.8;

color:#d9e3e6;

}


.btn-custom{

padding:12px 35px;

border-radius:30px;

font-weight:600;

margin-top:20px;

margin-right:15px;

}


.btn-login{

background:#00c6ff;

color:white;

}


.btn-register{

background:white;

color:#203a43;

}


.hero-icon{

font-size:220px;

color:#00e5ff;

}



/* Features */


.features{

padding:70px 0;

}


.feature-card{

padding:30px;

border:none;

border-radius:15px;

transition:.3s;

}


.feature-card:hover{

transform:translateY(-10px);

}



.feature-card i{

color:#00c6ff;

}



/* About */


.about{

background:white;

padding:70px 0;

}


.about h2{

font-weight:700;

}



/* Footer */


footer{

background:#0f2027;

color:white;

padding:25px;

text-align:center;

}


</style>


</head>


<body>



<!-- Navbar -->


<nav class="navbar navbar-expand-lg">


<a class="navbar-brand" href="index.jsp">

<i class="fa-solid fa-calendar-check"></i>

BookEase

</a>



<button class="navbar-toggler"
type="button"
data-toggle="collapse"
data-target="#menu">


<span class="navbar-toggler-icon"></span>


</button>




<div class="collapse navbar-collapse" id="menu">


<ul class="navbar-nav ml-auto">


<li class="nav-item">

<a class="nav-link" href="index.jsp">

Home

</a>

</li>



<li class="nav-item">

<a class="nav-link" href="services">

Services

</a>

</li>



<li class="nav-item">

<a class="nav-link" href="login.jsp">

Login

</a>

</li>



<li class="nav-item">

<a class="nav-link" href="register.jsp">

Register

</a>

</li>


</ul>


</div>


</nav>





<!-- Hero Section -->


<section class="hero">


<div class="container">


<div class="row align-items-center">


<div class="col-lg-6">


<h1>

Book Your

<span>

Appointments

</span>

Online

</h1>



<p>

BookEase helps you schedule appointments quickly and securely.
Manage your bookings with an easy-to-use appointment booking system.

</p>



<a href="login.jsp"
class="btn btn-custom btn-login">

Login

</a>



<a href="register.jsp"
class="btn btn-custom btn-register">

Register

</a>



</div>





<div class="col-lg-6 text-center">


<div class="hero-icon">


<i class="fa-solid fa-calendar-days"></i>


</div>


</div>


</div>


</div>


</section>






<!-- Features Section -->


<section class="features">


<div class="container">


<div class="text-center mb-5">


<h2>

Why Choose BookEase?

</h2>


<p>

Simple, Fast and Secure Appointment Management

</p>


</div>





<div class="row">



<div class="col-md-3">


<div class="card feature-card shadow text-center">


<i class="fa-solid fa-clock fa-3x"></i>


<h5 class="mt-3">

Quick Booking

</h5>


<p>

Book appointments within seconds.

</p>


</div>


</div>





<div class="col-md-3">


<div class="card feature-card shadow text-center">


<i class="fa-solid fa-user-shield fa-3x"></i>


<h5 class="mt-3">

Secure Login

</h5>


<p>

Your account is safe and protected.

</p>


</div>


</div>





<div class="col-md-3">


<div class="card feature-card shadow text-center">


<i class="fa-solid fa-calendar-check fa-3x"></i>


<h5 class="mt-3">

Easy Management

</h5>


<p>

Manage your appointments easily.

</p>


</div>


</div>





<div class="col-md-3">


<div class="card feature-card shadow text-center">


<i class="fa-solid fa-headset fa-3x"></i>


<h5 class="mt-3">

Support

</h5>


<p>

Get help whenever required.

</p>


</div>


</div>




</div>


</div>


</section>







<!-- About Section -->


<section class="about">


<div class="container text-center">


<h2>

About BookEase

</h2>


<p class="mt-4">


BookEase is an online appointment booking system
designed to make scheduling simple and convenient.
Users can register, login, view services and manage appointments easily.


</p>


</div>


</section>






<!-- Footer -->


<footer>


<p>

© 2026 BookEase | Appointment Booking System

</p>


</footer>





<!-- Bootstrap JS -->


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>



</body>


</html>