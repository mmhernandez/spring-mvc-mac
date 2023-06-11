<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Category</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<h1 class="text-center my-5">New Category</h1>
	<div class="w-50 mx-auto py-4 d-flex flex-column border-bottom">
		<a href="/">Back home</a>
	</div>
	
	<main class="w-50 mx-auto mt-4">
		<form:form action="/categories/new" method="post" modelAttribute="category">
			<div class="mb-3">
				<form:label path="name" class="form-label">Name</form:label>
				<form:input type="text" path="name" class="form-control" />
				<form:errors path="name" class="text-danger" />
			</div>
			<input type="submit" class="btn btn-success" value="Save" />
		</form:form>
	</main>

</body>
</html>