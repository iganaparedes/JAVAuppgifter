<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="model.LoginBean"%>
<%@ page import="model.ApiBean"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	LoginBean bean = (LoginBean) request.getAttribute("bean");
	out.print("Welcome " + bean.getName());

	ApiBean lineType = (ApiBean) request.getAttribute("lineType");
	out.print("<ul>");
	for (int i = 0; i < 5; i++) {
		out.print("<li>");
		out.print(lineType.getLineType().get(i));
		out.print("</li>");
	}
	out.print("</ul>");

	ApiBean journeyDateTime = (ApiBean) request.getAttribute("journeyDateTime");
	out.print("<ul>");
	for (int i = 0; i < 5; i++) {
		out.print("<li>");
		out.print(journeyDateTime.getJourneyTime().get(i));
		out.print("</li>");
	}
	out.print("</ul>");

	ApiBean journeyTo = (ApiBean) request.getAttribute("journeyTo");
	out.print("<ul>");
	for (int i = 0; i < 5; i++) {
		out.print("<li>");
		out.print(journeyTo.getJourneyTowards().get(i));
		out.print("</li>");
	}
	out.print("</ul>");
	%>







</body>
</html>

