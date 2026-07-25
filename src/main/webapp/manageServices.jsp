<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="model.Service"%>

<%
@SuppressWarnings("unchecked")
List<Service> services =
(List<Service>) request.getAttribute("services");
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

<title>Manage Services | BookEase</title>

<link
href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
rel="stylesheet">

<link
rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

</head>

<body class="bg-light">

<div class="container mt-5">

<h2 class="text-center mb-4">

<i class="fas fa-tools"></i>

Manage Services

</h2>

<div class="mb-3 text-end">

<a href="addService.jsp"
class="btn btn-success">

<i class="fas fa-plus"></i>

Add Service

</a>

</div>

<table class="table table-bordered table-hover">

<thead class="table-dark">

<tr>

<th>ID</th>

<th>Service Name</th>

<th>Duration (Minutes)</th>

<th>Price</th>

<th>Action</th>

</tr>

</thead>

<tbody>

<%

if(services != null && !services.isEmpty()){

for(Service service : services){

%>

<tr>

<td><%= service.getServiceId() %></td>

<td><%= service.getName() %></td>

<td><%= service.getDurationMinutes() %></td>

<td>₹ <%= service.getPrice() %></td>

<td>

<a
href="editService?id=<%= service.getServiceId() %>"
class="btn btn-primary btn-sm">

Edit

</a>

<a
href="deleteService?id=<%= service.getServiceId() %>"
class="btn btn-danger btn-sm"
onclick="return confirm('Delete this service?');">

Delete

</a>

</td>

</tr>

<%

}

}else{

%>

<tr>

<td colspan="5" class="text-center">

No Services Available

</td>

</tr>

<%

}

%>

</tbody>

</table>

<div class="text-center">

<a
href="adminDashboard.jsp"
class="btn btn-secondary">

Back to Dashboard

</a>

</div>

</div>

</body>

</html>