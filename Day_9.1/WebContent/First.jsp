<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>First Page</title>
	</head>
	<body>
		<%
			int[] arr = { 1, 2, 3, 4, 5 };
			session.setAttribute("IntArr", arr);
		%>
		<%-- <c:set var="IntArr" value="${arr}" scope="session"/> --%>
		<%-- <jsp:forward page="Second.jsp"/> --%>
		<c:url var="location" value="Second.jsp" scope="page"/>
		<c:redirect url="${location}"/>
	</body>
</html>