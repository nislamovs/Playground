package com.druggers.servlets;

import com.druggers.data.MenuDao;
import com.druggers.data.MenuDaoFactory;
import com.druggers.domain.Order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DruglabAsyncTask implements Runnable {

	private AsyncContext asyncContext;
		
	public void setAsyncContext(AsyncContext asyncContext) {
		this.asyncContext = asyncContext;
	}

	@Override
	public void run() {
		
		HttpServletRequest request = (HttpServletRequest)asyncContext.getRequest();
		HttpServletResponse response = (HttpServletResponse)asyncContext.getResponse();
		
		PrintWriter out;
		try {
			out = response.getWriter();
		} catch (IOException e1) {
			asyncContext.complete();
			throw new RuntimeException(e1);
		}
		response.setContentType("text/html");
		
		Long size = Long.parseLong(request.getParameter("size"));
		
		MenuDao dao = MenuDaoFactory.getMenuDao();
		
		while (dao.getAllOrders().size() < size) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				asyncContext.complete();
				throw new RuntimeException(e);
			}
		}
		
		Order order = dao.getOrder(size);
		out.println("<p><strong>Next order:</strong><br/>" + order.toString() + "</p>");
		out.close();
		
		asyncContext.complete();

	}

}
