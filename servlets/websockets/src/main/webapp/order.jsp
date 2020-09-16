<%@ page import = "com.druggers.domain.MenuItem" %>
<%@ page import = "java.util.List" %>

<html>
	<body>
		<jsp:include page="/header.jsp" />
		<h2>Order your drug :)</h2>

		<form action='orderReceived.html' method='POST' >
			<table style="width:30%">
			  <tr>
				<th style="text-align:left">Drug name:</th>
				<th style="text-align:left">Count:</th>
			  </tr>
				<%

				List<MenuItem> menuItems = (List<MenuItem>)request.getAttribute("menuItems");

				for (MenuItem menuItem : menuItems) {
					out.println("<tr>");
					out.println("<td>" + menuItem + "</td>");
					out.println("<td>" + "<input type='text' name='item_" +menuItem.getId() +"' />" + "<td>");
					out.println("</tr>");
				}
				%>

			</table>
		<input type='submit' />
		</form>
		
		<jsp:include page="/footer.jsp" />
	</body>
</html>