<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%-- <%	
			for( int count = 1; count <= 10; ++ count )
			{
				out.println("<h3>"+count+"</h3><br/>");
			}
		%> --%>
		
		<%-- <hr>
		<%
			Date date = new Date();
			out.println( date.toString() );
		%>
		<hr>
		<%= new Date().toString() %> --%>
		
		
		<%-- <%
			for( int count = 1; count <= 10; ++ count )
			{
		%>
			<%= count %>
		<%
			}
		%> --%>
		
		<%!
			int count = 0;
		%>
		<%
			++ count;
			out.println("Count "+count);
		%>
	</body>
</html>