<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Error page</title>
	</head>
	<body>
		<%-- <%= exception.toString() %> --%>
		<%= pageContext.getErrorData().getServletName()%><br/>
		<%= pageContext.getErrorData().getRequestURI()%><br/>
		<%= pageContext.getErrorData().getStatusCode()%><br/>
		<%= pageContext.getErrorData().getThrowable().getClass().getSimpleName()%><br/>
		<%= pageContext.getErrorData().getThrowable().getMessage()%><br/>
		
	</body>
</html>