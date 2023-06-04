<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lookify</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<main class="w-50">
		<h1 class="my-5">Top Songs</h1>
		<c:forEach var="song" items="${ songList }">
			<div>
				<c:out value="${ song.rating } - "/>
				<a href="/song/${ song.id }"><c:out value="${ song.title }" /></a>
				<c:out value=" - ${ song.artist }"/>
			</div>
		</c:forEach>
	</main>

</body>
</html>