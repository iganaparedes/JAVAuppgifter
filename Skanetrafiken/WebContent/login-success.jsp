<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="mvc.LoginBean" %>
     <%@page import="mvc.SkaneLink" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
LoginBean bean = (LoginBean)request.getAttribute("bean");

out.print("Welcome " + bean.getName());
SkaneLink sL = new SkaneLink();




%>







</body>
</html>

