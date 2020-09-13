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

@WebServlet("/searchResults.html")
public class MenuSearchServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String searchTerm = request.getParameter("searchTerm");

        MenuDao menuDao = MenuDaoFactory.getMenuDao();
        List<MenuItem> menuItems = menuDao.find(searchTerm);

        out.println("<html><body>");
        out.println("<h1>Drugstore</h1>");
        out.println("<h2>Drugs containing " + searchTerm + ":</h2>");

        if (menuItems.size() > 0) {
            out.println("<ul>");
            for (MenuItem menuItem : menuItems) {
                out.println("<li>" + menuItem + " " + menuItem.getDescription() + "</li>");
            }
            out.println("</ul>");
        } else {
            out.println("No drugs found containing '" + searchTerm + "' criteria.");
        }

        out.println("<a href='searchResults.html?searchTerm=antibiotic' >View all of antibiotics");
        out.println("</body></html>");
    }
}
