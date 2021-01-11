
<%
String chosen = request.getParameter("chooseOption");

out.println("You chose " + chosen + "!");
out.println("Click to see a " + chosen + "!");

out.println("<input type='submit' name='theButtonToSee' value='See a " + chosen + "' >");
%>

