package com.druggers.servlets;

import com.druggers.data.MenuDao;
import com.druggers.data.MenuDaoFactory;
import com.druggers.domain.MenuItem;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("")
public class ViewMenuServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        MenuDao menuDao = MenuDaoFactory.getMenuDao();
        List<MenuItem> menuItems = menuDao.getFullMenu();

        request.setAttribute("menuItems", menuItems);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/menu.jsp");
        dispatch.forward(request, response);
    }
}
