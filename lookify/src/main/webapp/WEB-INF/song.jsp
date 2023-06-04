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
		<form:form action="/song/${ song.id }" method="post" modelAttribute="song" class="bg-dark text-light rounded p-4">
			<input type="hidden" name="_method" value="put" />
			<h1 class="mb-4">Edit Song</h1>
			<div class="mb-3">
				<form:label path="title" class="form-label">Title</form:label>
				<form:input type="text" path="title" class="form-control" value="${ song.title }" />
				<form:errors path="title" class="text-danger" />
			</div>
			<div class="mb-3">
				<form:label path="artist" class="form-label">Artist</form:label>
				<form:input type="text" path="artist" class="form-control" value="${ song.artist }"/>
				<form:errors path="artist" class="text-danger" />
			</div>
			<div class="mb-3">
				<form:label path="rating" class="form-label">Rating</form:label>
				<form:input type="number" min="1" max="10" path="rating" class="form-control" value="${ song.rating }"/>
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