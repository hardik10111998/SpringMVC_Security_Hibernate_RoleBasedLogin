<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <p class="navbar-brand" >Welcome ${pageContext.request.userPrincipal.name}<p>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href='<c:url value="/logout"></c:url>'>logout</a></li>
  
    </ul>
  </div>
</nav>
 <div class="container">
 <h2 alihn="center">Your Profile</h2><br>
<div class="table-responsive">
<table class="table table-hover">
<tr>

<th>UserName</th>
<th>UserPassword</th>
<th>UserEmail</th>
<th>UserAddress</th>
</tr>

<tr>

<td><c:out value="${user.userName}"></c:out></td>
<td><c:out value="${user.password}"></c:out></td>
<td><c:out value="${user.userEmail}"></c:out></td>
<td><c:out value="${user.userAddress}"></c:out></td>
<td><a href="edit?userId=${user.userId }">Edit</a>

</tr>

</table>
</div>
</div>

</body>
</html>