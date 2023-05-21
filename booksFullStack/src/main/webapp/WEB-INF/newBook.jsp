<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Books</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<main class="my-5 w-75 mx-auto">	
		<h1>New Book</h1>
		<form:form action="/books" method="post" modelAttribute="newBook" class="bg-light py-4 px-5 rounded">
			<div class="mb-3">
				<form:label path="title" class="form-label">Title</form:label>
				<form:input type="text" path="title" class="form-control" />
				<p class="text-danger">
					<form:errors path="title"></form:errors>
				</p>
			</div>
			<div class="mb-3">
				<form:label path="description" class="form-label">Description</form:label>
				<form:textarea path="description" id="" cols="30" rows="3" class="form-control"></form:textarea>
				<p class="text-danger">
					<form:errors path="description"></form:errors>
				</p>
			</div>
			<div class="mb-3">
				<form:label path="language" class="form-label">Language</form:label>
				<form:input type="text" path="language" class="form-control" />
				<p class="text-danger">
					<form:errors path="language"></form:errors>
				</p>
			</div>
			<div class="mb-3">
				<form:label path="numberOfPages" class="form-label">Number of Pages</form:label>
				<form:input type="number" path="numberOfPages" class="form-control" />
				<p class="text-danger">
					<form:errors path="numberOfPages"></form:errors>
				</p>
			</div>
			<input type="submit" value="Save" class="btn btn-primary" />
		</form:form>
	</main>

</body>
</html>