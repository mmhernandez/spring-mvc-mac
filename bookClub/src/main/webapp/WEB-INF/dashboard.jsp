<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Book Club - Read Share</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<header class="w-50 mx-auto my-5 d-flex justify-content-between">
		<div>
			<h1>Welcome <c:out value="${ user.name }" /></h1>
			<p>Here are the books from everyone's shelves:</p>
		</div>
		<div class="d-flex flex-column gap-4">
			<a href="/logout">logout</a>
			<a href="/books/add">+ Add book!</a>
		</div>
	</header>

	<main class="w-50 mx-auto">
		<p class="fs-5">Available books to borrow</p>
			<table class="table mb-5">
				<thead>
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Author Name</th>
						<th>Owner</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${ books }">
						<c:if test="${ book.borrower == null }">
							<tr>
								<td><c:out value="${ book.id }" /></td>
								<td>
									<a href="/books/${ book.id }"><c:out value="${ book.title }" /></a>
								</td>
								<td><c:out value="${ book.author }" /></td>
								<td><c:out value="${ book.user.name }" /></td>
								<td class="d-flex gap-2 align-items-center">
									<c:if test="${ user.id == book.user.id }">
										<a href="/books/edit/${ book.id }">Edit</a>
										<form action="/books/${ book.id }" method="post">
											<input type="hidden" name="_method" value="delete" />
											<input type="submit" value="Delete" class="btn btn-link link-danger"/>
										</form>
									</c:if>
									<c:if test="${ user.id != book.user.id }">
										<a href="/books/borrow/${ book.id }">Borrow</a>
									</c:if>
								</td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		
		<p class="fs-5">Books I'm borrowing</p>
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Author Name</th>
						<th>Owner</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${ books }">
						<c:if test="${ book.borrower.id == user.id }">
							<tr>
								<td><c:out value="${ book.id }" /></td>
								<td>
									<a href="/books/${ book.id }"><c:out value="${ book.title }" /></a>
								</td>
								<td><c:out value="${ book.author }" /></td>
								<td><c:out value="${ book.user.name }" /></td>
								<td>
									<a href="/books/return/${ book.id }">Return</a>
								</td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
	</main>
	
</body>
</html>