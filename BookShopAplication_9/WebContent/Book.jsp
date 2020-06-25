<%@page import="pojo.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Book Page</title>
	</head>
	<body>
		<form action="Cart.jsp" method="post">
			<jsp:useBean id="bb" class="beans.BookBean" scope="session"/>
				<jsp:setProperty name="bb" property="*" />
					${bb.fetchBooks()}
				<%
					for( Book book : bb.getBookList())
					{
						pageContext.setAttribute("Book", book);
				%>
						<input type="checkbox" name="Books" value="${Book.bookId}"/>${Book}<br/>
				<%		
					}
				%>	
			<input type="submit" value="Add To Cart"/>
		</form>
	</body>
</html>