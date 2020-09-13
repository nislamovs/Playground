package com.druggers.servlets;

import com.druggers.data.MenuDao;
import com.druggers.data.MenuDaoFactory;
import com.druggers.domain.MenuItem;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static java.time.LocalDate.now;

@WebServlet("")
public class ViewMenuServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        MenuDao menuDao = MenuDaoFactory.getMenuDao();
        List<MenuItem> menuItems = menuDao.getFullMenu();

        out.println("<html><body>");
        out.println("<h1>Drugstore</h1>");
        out.println("<h2>Menu:</h2>");

        out.println("<ul>");

        for (MenuItem menuItem: menuItems) {
            out.println("<li>" + menuItem + "</li>");
        }

        out.println("</ul>");

        out.println("</body></html>");
    }
}
