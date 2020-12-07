package servlets;

import classes.Client;
import services.DaoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class clientSearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputValue = req.getParameter("searchInput");
        String inputOption = req.getParameter("searchOption");
        List<Client> searchList;
        try {
            searchList = DaoService.clientDAO.search(inputOption, inputValue);
            DaoService.clientDAO.clientList = searchList;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("clientTable.jsp").forward(req, resp);
    }
}
