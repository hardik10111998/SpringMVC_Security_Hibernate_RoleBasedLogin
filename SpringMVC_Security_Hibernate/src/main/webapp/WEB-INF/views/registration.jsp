<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="registration" method="post" >
<table align="center" border="1px solid green">
<tr>
	<td>
	<label>UserName</label>
	</td>
	<td>
	<input type="text" name="userName">
	</td>
</tr>
<tr>
	<td>
		<label>Password</label>
	</td>
	<td>
		<input type="password" name="password">
	</td>
<tr>
	<td>
	<label>UserAddress</label>
	</td>
	<td>
	<input type="text" name="userAddress">
	</td>
</tr>
<tr>
	<td>
	<label>UserEmail</label>
	</td>
	<td>
	<input type="text" name="userEmail">
	</td>
</tr>
	<tr>
	<td>
	</td>
	<td>
	<input type="submit" value="submit">
	</td>
</tr>
</table>
</form>
</body>
</html>