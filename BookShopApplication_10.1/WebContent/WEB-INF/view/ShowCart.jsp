<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Show Cart</title>
	</head>
	<body>
		<form action="controller?page=Logout" method="post">
				<c:forEach var="book" items="${requestScope.cart}">
					<c:out  value="${book}"/> <br/>	
				</c:forEach>
			<input type="submit" value="Logout"/> 
		</form>
	</body>
</html>