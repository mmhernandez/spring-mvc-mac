<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	
	<nav class="d-flex justify-content-end w-50 mx-auto mt-5 pt-5">
		<a href="/dojo/new">+ Add Dojo</a>
	</nav>

	<main class="w-50 mx-auto mt-5 p-5">
		<h1>Dojos</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Dojo</th>
					<th>Created Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dojo" items="${ dojos }">
					<tr>
						<td>
							<a href="/dojo/${ dojo.id }"><c:out value="${ dojo.name }" /></a>
						</td>
						<td><fmt:formatDate type="date" value="${ dojo.createdAt }" /></td>
					</tr>
				</c:forEach>	
			</tbody>
		</table>
	</main>

</body>
</html>