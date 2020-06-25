<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cart Page</title>
	</head>
	<body>
		<jsp:useBean id="cb" class="beans.CartBean" scope="session"/>
			<jsp:setProperty name="cb" property="selectedIds" param="Books" />
			<c:url var="location" value="${cb.addToCart()}.jsp"/>
			<c:redirect url="${location}"/>	
	</body>
</html>