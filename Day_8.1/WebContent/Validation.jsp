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
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			User user = dao.validate(email, password);
			if( user != null )
			{
		%>	
			<%= user.toString()%><br/>
			<a href="Login.jsp">Logout</a>
		<%
			}
			else
			{
		%>
			Invalid email or password.<a href="Login.jsp">Retry</a>
		<%		
			}
		%>
		
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