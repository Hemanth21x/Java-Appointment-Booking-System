<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="model.Service"%>

<%
Service service = (Service) request.getAttribute("service");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Edit Service</title>

<link
href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

<div class="row justify-content-center">

<div class="col-md-6">

<div class="card shadow">

<div class="card-header bg-primary text-white">

<h3 class="text-center">

Edit Service

</h3>

</div>

<div class="card-body">

<form action="editService" method="post">

<input
type="hidden"
name="serviceId"
value="<%= service.getServiceId() %>">

<div class="mb-3">

<label>Service Name</label>

<input
type="text"
name="name"
class="form-control"
value="<%= service.getName() %>"
required>

</div>

<div class="mb-3">

<label>Duration (Minutes)</label>

<input
type="number"
name="duration"
class="form-control"
value="<%= service.getDurationMinutes() %>"
required>

</div>

<div class="mb-3">

<label>Price</label>

<input
type="number"
step="0.01"
name="price"
class="form-control"
value="<%= service.getPrice() %>"
required>

</div>

<div class="text-center">

<button
type="submit"
class="btn btn-primary">

Update Service

</button>

<a
href="manageServices"
class="btn btn-secondary">

Back

</a>

</div>

</form>

</div>

</div>

</div>

</div>

</div>

</body>

</html>