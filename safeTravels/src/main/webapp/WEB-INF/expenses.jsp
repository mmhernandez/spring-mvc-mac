<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Safe Travels</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<nav class="my-5 w-50 mx-auto d-flex justify-content-end">
		<a href="/expense" class="btn btn-success">+ New Expense</a>
	</nav>

	<main class="m-5 w-50 mx-auto">
		<h1 class="mb-3">Safe Travels - Expenses</h1>
		<table class="table">
			<thead class="bg-dark text-success fw-bold">
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${ expenseList }">
					<tr>
						<td><c:out value="${ expense.name }"/></td>
						<td><c:out value="${ expense.vendor }"/></td>
						<td><fmt:formatNumber value = "${ expense.amount }" type = "currency"/></td>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>

</body>
</html>