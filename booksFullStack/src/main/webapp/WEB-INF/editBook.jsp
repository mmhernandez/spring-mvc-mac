<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ page isErrorPage="true" %>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Books</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
 
	 <main class="w-75 my-5 mx-auto">
		<h1>Edit Book</h1>
		<form:form action="/books/${book.id}" method="post" modelAttribute="book">
		    <input type="hidden" name="_method" value="put">
		    <div class="mb-3">
		        <form:label path="title" class="form-label">Title</form:label>
		        <form:input path="title" class="form-control"/>
		        <form:errors path="title"/>
		    </div>
		    <div class="mb-3">
		        <form:label path="description" class="form-label">Description</form:label>
		        <form:textarea path="description" class="form-control"/>
		        <form:errors path="description"/>
		    </div>
		    <div class="mb-3">
		        <form:label path="language" class="form-label">Language</form:label>
		        <form:input path="language" class="form-control"/>
		        <form:errors path="language"/>
		    </div>
		    <div class="mb-3">
		        <form:label path="numberOfPages" class="form-label">Pages</form:label>
		        <form:input type="number" path="numberOfPages" class="form-control"/>
		        <form:errors path="numberOfPages"/>     
		    </div>    
		    <input type="submit" value="Submit" class="btn btn-primary"/>
		    <a href="/books" class="btn btn-secondary ms-2">Cancel</a>
		</form:form>
	</main>
	
</body>
</html>