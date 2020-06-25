<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="bk" uri="http://www.sunbeaminfo.com/java/online" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Show Cart</title>
	</head>
	<body>
		<form action="controller?page=Logout" method="post">
			<table>
				<c:forEach var="book" items="${BookCart}">
					<tr>
						<td> <c:out value="${book.bookId}"/> </td>
						<td> <c:out value="${book.subjectName}"/> </td>
						<td> <c:out value="${book.bookName}"/> </td>
						<td> <c:out value="${book.authorName}"/> </td>
						<td> <c:out value="${book.price}"/> </td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4" align="center"> <input type="submit" value="Logout"/> </td>
				</tr>
			</table>
			 
		</form>
	</body>
</html>