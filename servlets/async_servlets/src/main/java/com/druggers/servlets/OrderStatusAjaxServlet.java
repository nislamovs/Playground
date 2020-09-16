package com.druggers.servlets;

import com.druggers.data.MenuDao;
import com.druggers.data.MenuDaoFactory;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updatedStatus")
public class OrderStatusAjaxServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Long id = Long.valueOf(request.getParameter("id"));
		MenuDao dao = MenuDaoFactory.getMenuDao();
		String status = dao.getOrder(id).getStatus();
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		JSONObject json = new JSONObject();
		json.put("status", status);
		
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		json.put("time", sdf.format(new Date()));
		out.write(json.toString());
		out.close();
	}
}
