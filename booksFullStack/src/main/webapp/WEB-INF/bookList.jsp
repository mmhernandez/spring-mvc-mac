<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Books</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<main class="my-5 w-75 mx-auto">
		<div class="d-flex justify-content-between align-items-center">
			<h1>All Books</h1>
			<a href="/books/new" class="btn btn-success">+ Book</a>
		</div>
		<table class="table mt-3">
			<thead class="bg-light">
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Language</th>
					<th>Pages</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${ bookList }">
					<tr>
						<td><c:out value="${ book.id }" /></td>
						<td>
							<a href="/books/${ book.id }">
								<c:out value="${ book.title }" />
							</a>
						</td>
						<td><c:out value="${ book.language }" /></td>
						<td><c:out value="${ book.numberOfPages }" /></td>
						<td><a href="/books/${book.id}/edit">Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>

</body>
</html>