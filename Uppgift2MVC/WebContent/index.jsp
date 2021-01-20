<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/Uppgift2" method="post">
<p> Enter your username:</p> <input type="text" name="usernameOne">
<p> Enter your password: </p> <input name="passOne" type="password">
<input type="submit" value="Login">

</form>

</body>
</html>