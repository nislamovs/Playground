package com.druggers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.druggers.data.MenuDao;
import com.druggers.data.MenuDaoFactory;
import com.druggers.domain.MenuItem;

@WebServlet("/order.html")
@ServletSecurity(@HttpConstraint(rolesAllowed={"user"}))
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

		MenuDao menuDao = MenuDaoFactory.getMenuDao();
		List<MenuItem> menuItems = menuDao.getFullMenu();

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
