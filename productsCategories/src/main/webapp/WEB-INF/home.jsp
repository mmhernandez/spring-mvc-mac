<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<h1 class="text-center my-5">Home Page</h1>
	<div class="w-50 mx-auto py-4 d-flex flex-column border-bottom">
		<a href="/products/new">New Product</a>
		<a href="/categories/new">New Category</a>
	</div>
	
	<main class="w-50 mx-auto mt-4">
		<table class="table">
			<thead class="bg-light">
				<tr>
					<th>Products</th>
					<th>Categories</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<ul>
						<c:forEach var="product" items="${ products }">	
							<li>${ product.name }</li>
						</c:forEach>
						</ul>
					</td>
					<td>
						<ul>
						<c:forEach var="category" items="${ categories }">	
							<li>${ category.name }</li>
						</c:forEach>
						</ul>
					</td>
				</tr>
			</tbody>
		</table>
	</main>

</body>
</html>