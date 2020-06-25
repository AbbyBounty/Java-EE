<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login Page</title>
	</head>
	<body>
	<jsp:useBean id="ub" class="beans.UserBean" scope="session" />
		${ub.message}
		<form action="Validation.jsp" method="post">
			<table>
				<tr>
					<td>Email:</td>
					<td> <input type="text" name="email"/> </td>
				<td>
				<tr>
					<td>Password:</td>
					<td> <input type="password" name="password"/> </td>
				<td>
				<tr>
					<td><a href="NewUser.jsp">New User</a></td>
					<td> <input type="submit" name="Login"/> </td>
				<td>
				</tr>
			</table>
		</form>
	</body>
</html>