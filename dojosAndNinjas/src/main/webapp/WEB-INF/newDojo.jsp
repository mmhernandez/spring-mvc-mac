<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dojos and Ninjas</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<main class="w-50 mx-auto mt-5 p-5 bg-light rounded border border-5 border-warning">
		<h1 class="mt-3 mb-4">New Dojo</h1>
		<form:form action="/dojo/create" method="post" modelAttribute="dojo">
			<div class="mb-3">
				<form:label path="name" class="form-label">Name</form:label>
				<form:input type="text" path="name" class="form-control" />
				<form:errors path="name" class="text-danger" />
			</div>
			<a href="/dojos" class="btn btn-outline-secondary mt-3">Back to Dojo List</a>
			<input type="submit" class="btn btn-warning mt-3" value="Save" />
		</form:form>
	</main>

</body>
</html>