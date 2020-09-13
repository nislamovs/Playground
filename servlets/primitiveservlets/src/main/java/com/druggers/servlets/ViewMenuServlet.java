package com.druggers.servlets;

import com.druggers.data.MenuDataService;
import com.druggers.domain.MenuItem;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static java.time.LocalDate.now;

public class ViewMenuServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        MenuDataService menuDataService = new MenuDataService();
        List<MenuItem> menuItems = menuDataService.getFullMenu();

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
