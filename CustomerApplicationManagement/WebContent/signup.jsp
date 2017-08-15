<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration | Customer Application Management</title>
</head>
<body>

	<h1>Sign Up</h1>

	<form action="register" method="post">

		<table cellpadding="5" cellspacing="5">
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Email ID</td>
				<td><input type="text" name="emailId" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><a href="index.jsp">Sign In</a></td>
				<td align="right"><input type="submit" value="Register" /></td>
			</tr>
		</table>

	</form>

</body>
</html>