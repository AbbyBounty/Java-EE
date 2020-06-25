<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Subject Page</title>
	</head>
	<body>
		<form action="Book.jsp" method="post">
			<jsp:useBean id="sb" class="beans.SubjectBean" scope="page"/>
			${sb.fetchSubjects()}
			<%
				for( String subject : sb.getSubjectList())
				{
					pageContext.setAttribute("Subject", subject);
			%>
					<input type="radio" name="subject" value="${Subject}"/> ${Subject} <br/>
			<%		
				}
			%>
		<input type="submit" value="Show Books"/>
		<input type="submit" value="Show Cart" formaction="ShowCart.jsp"/>
		</form>
	</body>
</html>