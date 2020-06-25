<%@page import="javax.xml.ws.Response"%>
<%@page import="sun.security.provider.certpath.ResponderId"%>
<%@page import="pojo.User"%>
<%@page import="dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Validation Page</title>
	</head>
	<body>
		<jsp:useBean id="ub" class="beans.UserBean" scope="session"/>
			<jsp:setProperty name="ub" property="*" />
			<c:url var="location" value="${ub.validateUser()}.jsp"/>
			<c:redirect url="${location}"/>
	</body>
</html>