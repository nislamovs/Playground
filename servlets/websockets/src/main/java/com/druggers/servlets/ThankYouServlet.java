package com.druggers.servlets;


import com.druggers.data.MenuDao;
import com.druggers.data.MenuDaoFactory;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/thankYou.html")
@ServletSecurity(@HttpConstraint(rolesAllowed={"user"}))
public class ThankYouServlet extends HttpServlet {

	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


		HttpSession session = request.getSession();
		Long orderId = (Long) session.getAttribute("orderId");

		MenuDao dao = MenuDaoFactory.getMenuDao();

		Double total = dao.getOrderTotal(orderId);
		String status = dao.getOrder(orderId).getStatus();

		if (total == null) {
			response.sendRedirect("/order.html");
			return;
		}

		request.setAttribute("total", total);
		request.setAttribute("status", status);
		request.setAttribute("id", orderId);
		request.setAttribute("currency", "USD");

		ServletContext context = getServletContext();
		RequestDispatcher dispatch = context.getRequestDispatcher("/thankYou.jsp");
		dispatch.forward(request, response);
		
	}
}
