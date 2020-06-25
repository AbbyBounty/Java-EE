<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Second Page</title>
	</head>
	<body>
		<%-- <c:forEach var="count" begin="0" end="9" step="1">
			<c:out value="${count}"></c:out>
		</c:forEach> --%>
		
		<c:forEach var="element" items="${sessionScope.IntArr}">
			<c:out value="${element}"/>
		</c:forEach>
	</body>
</html>