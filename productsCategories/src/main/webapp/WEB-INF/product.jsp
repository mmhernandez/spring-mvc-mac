<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Product Page</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<h1 class="text-center my-5"><c:out value="${ product.name }" /></h1>
	<div class="w-50 mx-auto py-4 d-flex flex-column border-bottom">
		<a href="/">Back home</a>
	</div>
	
	<main class="w-50 mx-auto mt-4">
		<div class="py-4 border-bottom">
			<p class="fs-3">Categories:</p>
			<ul>
				<c:forEach var="category" items="${ categoryList }">
					<li><c:out value="${ category.name }"/></li>
				</c:forEach>
			</ul>
		</div>
		<div class="mt-4">
			<p class="fs-3">Add Category</p>
			<form action="/products/${ product.id }/add/category" method="post">
				<input type="hidden" name="_method" value="put" />
				<div class="d-flex gap-2 w-100">
					<select name="category" class="w-25">
						<c:forEach var="eachCategory" items="${ availableCategories }">
							<option value="${ eachCategory.id }"><c:out value="${ eachCategory.name }"/></option>
						</c:forEach>
					</select>
					<input type="submit" class="btn btn-success" value="Add" />
				</div>
			</form>
		</div>
	</main>

</body>
</html>