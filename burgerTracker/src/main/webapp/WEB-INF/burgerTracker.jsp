<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
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

	<section class="mt-5 mx-auto w-75">
		<h1>Burger Tracker</h1>
		<table class="table mb-5">
			<thead class="bg-light">
				<tr>
					<th>Burger Name</th>
					<th>Restaurant Name</th>
					<th>Rating</th>
					<th>Notes</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="burger" items="${ burgerList }">
					<tr>
						<td><c:out value="${ burger.name }"/></td>
						<td><c:out value="${ burger.restaurantName }"/></td>
						<td><c:out value="${ burger.rating }"/></td>
						<td><c:out value="${ burger.notes }"/></td>
						<td class="d-flex gap-2">
							<p><a href="/burger/${ burger.id }/edit">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill text-info" viewBox="0 0 16 16">
								  <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
								</svg>
							</a></p>
							<p><a href="/burger/${ burger.id }/delete">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3 text-danger" viewBox="0 0 16 16">
								  <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"/>
								</svg>
							</a></p>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
	
	<section class="mt-5 mb-4 mx-auto w-50 bg-dark text-light rounded px-4 py-3">
		<p class="fs-1 text-info">Add a Burger:</p>
		<form:form action="/burger/add" method="post" modelAttribute="newBurger">
			<div class="mb-3">
				<form:label path="name" class="form-label">Burger Name</form:label>
				<form:input type="text" path="name" class="form-control" />
				<p class="text-danger">
					<form:errors path="name"></form:errors>
				</p>
			</div>
			<div class="mb-3">
				<form:label path="restaurantName" class="form-label">Restaurant Name</form:label>
				<form:input type="text" path="restaurantName" class="form-control" />
				<p class="text-danger">
					<form:errors path="restaurantName"></form:errors>
				</p>
			</div>
			<div class="mb-3">
				<form:label path="rating" class="form-label">Rating</form:label>
				<form:input type="number" min="1" max="5" path="rating" class="form-control" />
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