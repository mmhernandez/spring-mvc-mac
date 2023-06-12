<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Category Page</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<h1 class="text-center my-5"><c:out value="${ category.name }" /></h1>
	<div class="w-50 mx-auto py-4 d-flex flex-column border-bottom">
		<a href="/">Back home</a>
	</div>
	
	<main class="w-50 mx-auto mt-4">
		<div class="py-4 border-bottom">
			<p class="fs-3">Products:</p>
			<ul>
				<c:forEach var="product" items="${ productList }">
					<li><c:out value="${ product.name }"/></li>
				</c:forEach>
			</ul>
		</div>
		<div class="mt-4">
			<p class="fs-3">Add Product</p>
			<form action="/categories/${ category.id }/add/product" method="post">
				<input type="hidden" name="_method" value="put" />
				<div class="d-flex gap-2 w-100">
					<select name="product" class="w-25">
						<c:forEach var="eachProduct" items="${ availableProducts }">
							<option value="${ eachProduct.id }"><c:out value="${ eachProduct.name }"/></option>
						</c:forEach>
					</select>
					<input type="submit" class="btn btn-success" value="Add" />
				</div>
			</form>
		</div>
	</main>

</body>
</html>