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
		<form action="Logout.jsp" method="post">
			<jsp:useBean id="cb" class="beans.CartBean" scope="session"/>
			<jsp:useBean id="bb" class="beans.BookBean" scope="session"/>
				<c:forEach var="id" items="${cb.cart}">
					<jsp:setProperty name="bb" property="bookId" value="${id}"/>
						<bk:showBook bookId="${id}"/><br/>
				</c:forEach>
			<input type="submit" value="Logout"/> 
		</form>
	</body>
</html>