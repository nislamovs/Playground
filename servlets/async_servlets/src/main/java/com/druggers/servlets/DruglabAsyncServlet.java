package com.druggers.servlets;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value="/druglabAsyncServlet", asyncSupported = true)
public class DruglabAsyncServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		AsyncContext asyncContext = request.startAsync(request, response);
		DruglabAsyncTask task = new DruglabAsyncTask();
		task.setAsyncContext(asyncContext);
		asyncContext.start(task);
	}
}
