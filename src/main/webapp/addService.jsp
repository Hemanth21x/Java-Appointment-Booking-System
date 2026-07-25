<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Add Service | BookEase</title>

<link
href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

<div class="row justify-content-center">

<div class="col-md-6">

<div class="card shadow">

<div class="card-header bg-success text-white">

<h3 class="text-center">

Add New Service

</h3>

</div>

<div class="card-body">

<form action="addService" method="post">

<div class="mb-3">

<label class="form-label">

Service Name

</label>

<input
type="text"
name="name"
class="form-control"
required>

</div>

<div class="mb-3">

<label class="form-label">

Duration (Minutes)

</label>

<input
type="number"
name="duration"
class="form-control"
required>

</div>

<div class="mb-3">

<label class="form-label">

Price

</label>

<input
type="number"
step="0.01"
name="price"
class="form-control"
required>

</div>

<div class="text-center">

<button
type="submit"
class="btn btn-success">

Add Service

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