package com.druggers.servlets;

import com.druggers.data.MenuDao;
import com.druggers.data.MenuDaoFactory;
import com.druggers.domain.Order;
import com.druggers.websockets.DruglabDisplaySessionHandler;
import com.druggers.websockets.DruglabDisplaySessionHandlerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/processOrder.html")
public class ProcessOrderServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        MenuDao menuDao = MenuDaoFactory.getMenuDao();
        List<Order> orders;
        orders = menuDao.getAllOrders();
        request.setAttribute("orders", orders);

        List<String> statuses = new ArrayList<String>();
        statuses.add("order accepted");
        statuses.add("payment received");
        statuses.add("being prepared");
        statuses.add("ready for collection");

        request.setAttribute("statuses", statuses);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/processOrder.jsp");
        dispatch.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        MenuDao menuDao = MenuDaoFactory.getMenuDao();
        Long id = Long.valueOf(request.getParameter("id"));
        String status =  request.getParameter("status");
        System.out.println(id + " : " + status);
        menuDao.updateOrderStatus(id,status);

        Order order = menuDao.getOrder(id);
        DruglabDisplaySessionHandler handler = DruglabDisplaySessionHandlerFactory.getHandler();
        handler.amendOrder(order);

        doGet(request,response);
    }
}
