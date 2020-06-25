<%@page import="pojo.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
					<c:forEach var="book" items="${bb.bookList}">
						<input type="checkbox" name="Books" value="${book.bookId}"/>
							<c:out value="${book}"/><br/>
					</c:forEach>
			<input type="submit" value="Add To Cart"/>
		</form>
	</body>
</html>