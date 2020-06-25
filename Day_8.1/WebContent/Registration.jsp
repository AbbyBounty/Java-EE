<%@page import="java.sql.Date"%>
<%@page import="pojo.User"%>
<%@page import="dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Registration Page</title>
	</head>
	<body>
		<%!
			private UserDao dao;
			public void jspInit( )
			{
				try{
					this.dao = new UserDao();	
				}catch( Exception ex ){
					throw new RuntimeException( ex );
				}
				
			}
		%>
		
		<%
			User user = new User( );
			user.setFullName( request.getParameter("fullName") );
			user.setEmail( request.getParameter("email") );
			user.setPassword( request.getParameter("password") );
			user.setBirthDate( Date.valueOf(request.getParameter("birthDate")));
			dao.register(user);
		%>
		Registration is successful.<a href="Login.jsp">click here</a> to continue.
		<%!
			public void jspDestroy( ){
			try{
				this.dao.close();
			}catch( Exception ex ){
				throw new RuntimeException(ex );
			}
		}
		%>
	</body>
</html>