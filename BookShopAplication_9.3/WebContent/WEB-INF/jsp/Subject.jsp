<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Subject Page</title>
	</head>
	<body>
		<form action="controller?page=Book" method="post">
			<jsp:useBean id="sb" class="beans.SubjectBean" scope="session"/>
			<c:forEach var="subject" items="${sb.subjectList}">
				<input type="radio" name="subject" value="${subject}"/>
					 <c:out value="${subject}"/><br/>
			</c:forEach>
		<input type="submit" value="Show Books"/>
		<input type="submit" value="Show Cart" formaction="controller?page=ShowCart"/>
		</form>
	</body>
</html>