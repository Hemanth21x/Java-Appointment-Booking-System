<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Login | BookEase</title>

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

background:linear-gradient(135deg,#0f2027,#203a43,#2c5364);

height:100vh;

display:flex;

justify-content:center;

align-items:center;

}

.card{

width:450px;

border:none;

border-radius:15px;

box-shadow:0 10px 25px rgba(0,0,0,.3);

}

.card-header{

background:#0f2027;

color:white;

text-align:center;

font-size:28px;

font-weight:bold;

padding:20px;

border-radius:15px 15px 0 0;

}

.card-body{

padding:35px;

}

.form-control{

height:45px;

border-radius:8px;

}

.btn-login{

background:#00c6ff;

color:white;

font-weight:bold;

height:45px;

border:none;

}

.btn-login:hover{

background:#0099cc;

}

.register-link{

text-align:center;

margin-top:20px;

}

.register-link a{

text-decoration:none;

font-weight:bold;

}

</style>

</head>

<body>

<div class="card">

<div class="card-header">

<i class="fa-solid fa-user-lock"></i>

Login

</div>

<div class="card-body">

<form action="login" method="post">

<div class="form-group">

<label>Email</label>

<input
type="email"
name="email"
class="form-control"
placeholder="Enter Email"
required>

</div>

<div class="form-group">

<label>Password</label>

<input
type="password"
name="password"
class="form-control"
placeholder="Enter Password"
required>

</div>

<button
type="submit"
class="btn btn-login btn-block">

Login

</button>

</form>

<div class="register-link">

Don't have an account?

<a href="register.jsp">

Register

</a>

</div>

</div>

</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>