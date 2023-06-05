<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dojos and Nijas</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<nav class="d-flex justify-content-end w-50 mx-auto mt-5 pt-5">
		<a href="/dojos">Back to Dojo List</a>
	</nav>

	<main class="w-50 mx-auto mt-5 p-5">
		<h1 class="mb-5">${ dojo.name } Location Ninjas</h1>
		<table class="table">
			<thead class="bg-light">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ninja" items="${ ninjas }">
					<tr>
						<td><c:out value="${ ninja.firstName }" /></td>
						<td><c:out value="${ ninja.lastName }" /></td>
						<td><c:out value="${ ninja.age }" /></td>
					</tr>
				</c:forEach>	
			</tbody>
		</table>
	</main>

</body>
</html>