<%@page import="com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression"%>
<%@page import="beans.UserBean"%>
<%@page import="java.sql.Date"%>
<%@page import="pojo.User"%>
<%@page import="dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Registration Page</title>
	</head>
	<body>
		<jsp:useBean id="ub" class="beans.UserBean" scope="session" />
			<jsp:setProperty name="ub" property="*" />
			<c:url var="location" value="${ub.register()}.jsp"/>
			<c:redirect url="${location}"/>
	</body>
</html>