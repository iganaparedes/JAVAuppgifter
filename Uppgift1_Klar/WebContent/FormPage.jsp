
<%
String chosen = request.getParameter("chooseOption");


if (chosen.equals("cat")) {
response.sendRedirect("CatPage.jsp");
}
else if(chosen.equals("monkey")) {
	response.sendRedirect("MonkeyPage.jsp");
}
else if (chosen.equals("dog")) {
	response.sendRedirect("DogPage.jsp");
}

%>

