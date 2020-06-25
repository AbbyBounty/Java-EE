<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Show Cart</title>
	</head>
	<body>
		<form action="Logout.jsp" method="post">
			<jsp:useBean id="cb" class="beans.CartBean" scope="session"/>
			<jsp:useBean id="bb" class="beans.BookBean" scope="session"/>
			<%
				for( Integer id : cb.getCart())
				{
					pageContext.setAttribute("BookId", id);
			%>
					<jsp:setProperty name="bb" property="bookId" value="${BookId}"/>
					${bb.fetchBook()}
					${bb.book}<br/>
			<%		
				}
			%>
			<input type="submit" value="Logout"/> 
		</form>
	</body>
</html>