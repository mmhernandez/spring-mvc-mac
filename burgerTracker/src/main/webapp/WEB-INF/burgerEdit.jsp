<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Burger Tracker</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<section class="mt-5 mb-4 mx-auto w-50 bg-dark text-light rounded px-4 py-3">
		<h1 class="text-info">Edit Burger:</h1>
		<form:form action="/burger/${ burger.id }" method="post" modelAttribute="burger">
			<input type="hidden" name="_method" value="put"/>
			<div class="mb-3">
				<form:label path="name" class="form-label">Burger Name</form:label>
				<form:input type="text" path="name" class="form-control"/>
				<p class="text-danger">
					<form:errors path="name"></form:errors>
				</p>
			</div>
			<div class="mb-3">
				<form:label path="restaurantName" class="form-label">Restaurant Name</form:label>
				<form:input type="text" path="restaurantName" class="form-control"/>
				<p class="text-danger">
					<form:errors path="restaurantName"></form:errors>
				</p>
			</div>
			<div class="mb-3">
				<form:label path="rating" class="form-label">Rating</form:label>
				<form:input type="number" min="1" max="5" path="rating" class="form-control"/>
				<p class="text-danger">
					<form:errors path="rating"></form:errors>
				</p>
			</div>
			<div class="mb-3">
				<form:label path="notes" class="form-label">Notes</form:label>
				<form:textarea path="notes" cols="30" rows="3" class="form-control"></form:textarea>
				<p class="text-danger">
					<form:errors path="notes"></form:errors>
				</p>
			</div>
			<input type="submit" value="Save" class="btn btn-info" />
			<a href="/" class="btn btn-secondary ms-2">Cancel</a>
		</form:form>
	</section>

</body>
</html>