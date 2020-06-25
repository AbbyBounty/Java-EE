<%@page import="javax.xml.ws.Response"%>
<%@page import="sun.security.provider.certpath.ResponderId"%>
<%@page import="pojo.User"%>
<%@page import="dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%--  <%@ page errorPage="ErrorPage.jsp"%> --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Validation Page</title>
	</head>
	<body>
		<jsp:useBean id="ub" class="beans.UserBean" scope="session"/>
			<jsp:setProperty name="ub" property="*" />
			<jsp:forward page="${ub.validateUser()}.jsp"/>
	</body>
</html>