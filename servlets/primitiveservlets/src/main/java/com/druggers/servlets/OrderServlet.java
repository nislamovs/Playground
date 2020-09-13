package com.druggers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.druggers.data.MenuDataService;
import com.druggers.domain.MenuItem;

public class OrderServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body><h1>Drugstore</h1>");
		out.println("<h2>Order your drug :)</h2>");

		out.println("<form action='orderReceived.html' method='POST' >");
		out.println(
				"<table style=\"width:30%\">\n" +
				"  <tr>\n" +
				"    <th style=\"text-align:left\">Drug name:</th>\n" +
				"    <th style=\"text-align:left\">Count:</th>\n" +
				"  </tr>"
		);

		MenuDataService menuDataService = new MenuDataService();
		List<MenuItem> menuItems = menuDataService.getFullMenu();

		for (MenuItem menuItem : menuItems) {
			out.println("<tr>");
			out.println("<td>" + menuItem + "</td>");
			out.println("<td>" + "<input type='text' name='item_" +menuItem.getId() +"' />" + "<td>");
			out.println("</tr>");
		}

		out.println("</table>");
		out.println("<input type='submit' />");
		out.println("</form></body></html>");
		out.close();
	}
}
