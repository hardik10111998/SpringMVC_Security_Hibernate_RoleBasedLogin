<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
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
      <a class="navbar-brand" href="#">WebSiteNam</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href='<c:url value="/logout"></c:url>'>logout</a></li>
  
    </ul>
  </div>
  </nav>
  <div class="container">
  <h2 align="center">User Edit Form</h2>
  <hr>
  <form action="edit" method="post">
  <input type="text" name="userId" value="${user.userId }" readonly="readonly" hidden="true">
  <div class="form-group">
  <label>UserName: </label>
  <input type="text" name="userName" value="${user.userName }">
  </div>
  <div class="form-group">
  <label>UserPassword:</label>
   <input type="text" name="password" value="${user.password }">
  </div>
  <div class="form-group">
  <label>UserEmail:</label>
  <input type="text" name="userEmail" value="${user.userEmail }">
  
  </div>
  <div class="form-group">
  <label>UserAddress:</label>
  <input type="text" name="userAddress" value="${user.userAddress }">
  </div>
   <input type="submit" value="submit">
  </form>
  </div>
</body>
</html>