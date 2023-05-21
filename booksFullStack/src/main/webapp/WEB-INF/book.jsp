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
		<div class="d-flex justify-content-between align-items-center mb-4">
			<h1><c:out value="${ book.title }"/></h1>
			<a href="/books" class="btn btn-primary">Back to List</a>
		</div>
		<p><span class="fw-bold">Description: </span><c:out value="${ book.description }"/></p>
		<p><span class="fw-bold">Language: </span><c:out value="${ book.language }"/></p>
		<p><span class="fw-bold">Number of Pages: </span><c:out value="${ book.numberOfPages }"/></p>
	</main>
	
</body>
</html>