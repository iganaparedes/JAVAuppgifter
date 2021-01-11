<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Uppgift 1 javawebb</title>

</head>
<body>
	<jsp:include page="Header.html" />


	<form action="FormPage.jsp">
		<p>Please choose one:</p>

		<select name="chooseOption">
			<option value="cat">1</option>
			<option value="monkey">2</option>
			<option value="shark">3</option>

		</select> <input type="submit" value="Submit">

	</form>


	<jsp:include page="Footer.jsp" />
</body>

</html>