<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Third Page</title>
	</head>
	<body>
		<%-- <%
			String name = "";
			name = ( String )pageContext.getAttribute("Name");
			out.println("<h3>Page Scope : "+name+"</h3>");
			
			name = ( String )request.getAttribute("Name");
			out.println("<h3>Request Scope : "+name+"</h3>");
			
			name = ( String )session.getAttribute("Name");
			out.println("<h3>Session Scope Scope : "+name+"</h3>");
			
			name = ( String )application.getAttribute("Name");
			out.println("<h3>Application Scope : "+name+"</h3>");
		%> --%>
		
		<%-- <%
			String name = "";
			name = ( String )pageContext.getAttribute("Name", PageContext.PAGE_SCOPE);
			out.println("<h3>Page Scope : "+name+"</h3>");
			
			name = ( String )pageContext.getAttribute("Name", PageContext.REQUEST_SCOPE);
			out.println("<h3>Request Scope : "+name+"</h3>");
			
			name = ( String )pageContext.getAttribute("Name", PageContext.SESSION_SCOPE);
			out.println("<h3>Session Scope Scope : "+name+"</h3>");
			
			name = ( String )pageContext.getAttribute("Name", PageContext.APPLICATION_SCOPE);
			out.println("<h3>Application Scope : "+name+"</h3>");
		%> --%>
		
		<%-- Page Scope : <%= pageContext.getAttribute("Name", PageContext.PAGE_SCOPE)%> <br/>
		Request Scope : <%= pageContext.getAttribute("Name", PageContext.REQUEST_SCOPE)%> <br/>
		Session Scope : <%= pageContext.getAttribute("Name", PageContext.SESSION_SCOPE)%> <br/>
		Application Scope : <%= pageContext.getAttribute("Name",PageContext.APPLICATION_SCOPE)%> <br/> --%>
		
		<%-- Page Scope : <%= pageContext.getAttribute("Name")%> <br/>
		Request Scope : <%= request.getAttribute("Name")%> <br/>
		Session Scope : <%= session.getAttribute("Name")%> <br/>
		Application Scope : <%= application.getAttribute("Name")%> <br/> --%>
		
		<%-- Page Scope : ${pageScope.Name} <br/>
		Request Scope : ${requestScope.Name} <br/>
		Session Scope : ${sessionScope.Name} <br/>
		Application Scope : ${applicationScope.Name} <br/> --%>
		
		<%-- Page Scope : <%= pageContext.getAttribute("Name")%> <br/>
		Request Scope : <%= request.getAttribute("Name")%> <br/>
		Session Scope : <%= session.getAttribute("Name")%> <br/>
		Application Scope : <%= application.getAttribute("Name")%> <br/> --%>
		
		 <%-- <h1> Value : ${applicationScope.Value} </h1> --%>
		 <h1> Value : ${Value} </h1>
		
	</body>
</html>