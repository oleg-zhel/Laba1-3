package servlets;

import classes.Client;
import classes.Reserve;
import services.DaoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class reserveSearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputValue = req.getParameter("searchInput");
        String inputOption = req.getParameter("searchOption");
        List<Reserve> searchList;
        try {
            searchList = DaoService.reserveDAO.search(inputOption, inputValue);
            DaoService.reserveDAO.reserveList = searchList;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("clientTable.jsp").forward(req, resp);
    }
}
