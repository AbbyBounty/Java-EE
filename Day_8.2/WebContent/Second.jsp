<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Second Page</title>
	</head>
	<body>
		<%-- <%
			String name = request.getParameter("name");
			pageContext.setAttribute("Name", name);
			request.setAttribute("Name", name);
			session.setAttribute("Name", name);
			application.setAttribute("Name", name);
			
			response.sendRedirect("Third.jsp");
		%> --%>
		
		<%
			String name = request.getParameter("name");
			pageContext.setAttribute("Name", name, PageContext.PAGE_SCOPE);
			pageContext.setAttribute("Name", name, PageContext.REQUEST_SCOPE);
			pageContext.setAttribute("Name", name, PageContext.SESSION_SCOPE);
			pageContext.setAttribute("Name", name, PageContext.APPLICATION_SCOPE);
		
			String value = request.getParameter("name");
			//pageContext.setAttribute("Value", value, PageContext.APPLICATION_SCOPE);
			application.setAttribute("Value", value);
			
			//response.sendRedirect("Third.jsp");
			
			RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
			rd.forward(request, response);
		%>
	</body>
</html>