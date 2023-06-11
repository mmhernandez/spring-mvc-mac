<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Product</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<h1 class="text-center my-5">New Product</h1>
	<div class="w-50 mx-auto py-4 d-flex flex-column border-bottom">
		<a href="/">Back home</a>
	</div>
	
	<main class="w-50 mx-auto mt-4">
		<form:form action="/products/new" method="post" modelAttribute="product">
			<div class="mb-3">
				<form:label path="name" class="form-label">Name</form:label>
				<form:input type="text" path="name" class="form-control" />
				<form:errors path="name" class="text-danger" />
			</div>
			<div class="mb-3">
				<form:label path="description" class="form-label">Description</form:label>
				<form:input type="text" path="description" class="form-control" />
				<form:errors path="name" class="text-danger" />
			</div>
			<div class="mb-3">
				<form:label path="price" class="form-label">Price</form:label>
				<form:input type="number" step="0.01" path="price" class="form-control" />
				<form:errors path="name" class="text-danger" />
			</div>
			<input type="submit" class="btn btn-success" value="Save" />
		</form:form>
	</main>

</body>
</html>