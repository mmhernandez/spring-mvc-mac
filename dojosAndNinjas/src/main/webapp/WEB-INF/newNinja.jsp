<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<h1 class="mt-3 mb-4">New Ninja</h1>
		<form:form action="/ninja/create" method="post" modelAttribute="ninja">
			<div class="mb-3">
				<form:label path="firstName" class="form-label">First Name</form:label>
				<form:input type="text" path="firstName" class="form-control" />
				<form:errors path="firstName" class="text-danger" />
			</div>
			<div class="mb-3">
				<form:label path="lastName" class="form-label">Last Name</form:label>
				<form:input type="text" path="lastName" class="form-control" />
				<form:errors path="lastName" class="text-danger" />
			</div>
			<div class="mb-3">
				<form:label path="age" class="form-label">Age</form:label>
				<form:input type="number" path="age" class="form-control" />
				<form:errors path="age" class="text-danger" />
			</div>
			<div class="mb-3">
				<form:label path="dojo" class="form-label">Dojo</form:label>
				<form:select path="dojo" class="form-select">
					<c:forEach var="dojo" items="${ dojos }">
						<option value="${ dojo.id }">${ dojo.name }</option>
					</c:forEach>
				</form:select>
			</div>
			<a href="/dojos" class="btn btn-outline-secondary mt-3">Back to Dojo List</a>
			<input type="submit" class="btn btn-warning mt-3" value="Save" />
		</form:form>
	</main>

</body>
</html>