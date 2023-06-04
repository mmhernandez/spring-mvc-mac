<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lookify</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<main class="w-50 mx-auto mt-5">
		<form:form action="/song/new" method="post" modelAttribute="song" class="bg-light rounded p-4">
			<h1 class="mb-4">Add Song</h1>
			<div class="mb-3">
				<form:label path="title" class="form-label">Title</form:label>
				<form:input type="text" path="title" class="form-control" />
				<form:errors path="title" class="text-danger" />
			</div>
			<div class="mb-3">
				<form:label path="artist" class="form-label">Artist</form:label>
				<form:input type="text" path="artist" class="form-control" />
				<form:errors path="artist" class="text-danger" />
			</div>
			<div class="mb-3">
				<form:label path="rating" class="form-label">Rating</form:label>
				<form:input type="number" min="1" max="10" path="rating" class="form-control" />
				<form:errors path="rating" class="text-danger" />
			</div>
			<div class="d-flex justify-content-end gap-2">
				<a href="/dashboard" class="btn btn-secondary">Cancel</a>
				<input type="submit" value="Save" class="btn btn-primary" />
			</div>
		</form:form>
	</main>

</body>
</html>