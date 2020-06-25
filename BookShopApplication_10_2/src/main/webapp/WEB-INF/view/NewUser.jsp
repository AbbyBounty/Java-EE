<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>New User Page</title>
	</head>
	<body>
		<form action="controller?page=Registration" method="post">
			<table>
				<tr>
					<td>Full Name:</td>
					<td> <input type="text" name="fullName"/> </td>
				<td>
				<tr>
					<td>Email:</td>
					<td> <input type="text" name="email"/> </td>
				<td>
				<tr>
					<td>Password:</td>
					<td> <input type="password" name="password"/> </td>
				<td>
				<tr>
					<td>Birth Date:</td>
					<td> <input type="date" name="birthDate"/> </td>
				<td>
				<tr align="center">
					<td colspan="2"> <input type="submit" value="Register"/> </td>
				<td>
				</tr>
			</table>
		</form>
	</body>
</html>