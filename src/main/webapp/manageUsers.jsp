<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="model.User" %>


<%

// Get users list from servlet
@SuppressWarnings("unchecked")
List<User> users = (List<User>) request.getAttribute("users");


// Check admin login
User admin = (User) session.getAttribute("user");

if(admin == null || !"ADMIN".equalsIgnoreCase(admin.getRole())){

    response.sendRedirect("login.jsp");
    return;

}

%>


<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Manage Users | BookEase</title>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
rel="stylesheet">


<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">


</head>


<body class="bg-light">


<div class="container mt-5">


<h2 class="text-center mb-4">

<i class="fas fa-users"></i>

Manage Users

</h2>



<table class="table table-bordered table-hover">


<thead class="table-dark">

<tr>

<th>User ID</th>

<th>Name</th>

<th>Email</th>

<th>Role</th>

<th>Action</th>

</tr>

</thead>



<tbody>


<%

if(users != null && !users.isEmpty()){


    for(User u : users){


%>


<tr>


<td>
<%= u.getUserId() %>
</td>


<td>
<%= u.getName() %>
</td>


<td>
<%= u.getEmail() %>
</td>


<td>
<%= u.getRole() %>
</td>



<td>


<a href="deleteUser?id=<%= u.getUserId() %>"
class="btn btn-danger btn-sm"
onclick="return confirm('Delete this user?');">


<i class="fas fa-trash"></i>

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

No Users Found

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


<i class="fas fa-arrow-left"></i>

Back to Dashboard


</a>


</div>



</div>


</body>


</html>