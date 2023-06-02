<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Safe Travels</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<a href="/" class="m-5 p-5 w-50 btn-link text-center">Back to expense list</a>
	
	<main class="m-5 w-50 mx-auto">
		<div class="bg-light rounded p-3">
			<h1 class="mb-5">Add New Expense</h1>
			<form:form action="/expense" method="post" modelAttribute="expense">
				<div class="mb-3">
					<form:label path="name" class="form-label">Expense Name</form:label>
					<form:input type="text" path="name" class="form-control" />
					<form:errors path="name" class="text-danger"/>
				</div>
				<div class="mb-3">
					<form:label path="vendor" class="form-label">Vendor</form:label>
					<form:input type="text" path="vendor" class="form-control" />
					<form:errors path="vendor" class="text-danger"/>
				</div>
				<div class="mb-3">
					<form:label path="amount" class="form-label">Amount</form:label>
					<form:input type="number" path="amount" class="form-control" />
					<form:errors path="amount" class="text-danger"/>
				</div>
				<div class="mb-3">
					<form:label path="description" class="form-label">Description</form:label>
					<form:input type="text" path="description" class="form-control" />
					<form:errors path="description" class="text-danger"/>
				</div>
				<input type="submit" value="Save" class="btn btn-success" />
			</form:form>
		</div>
	</main>

</body>
</html>