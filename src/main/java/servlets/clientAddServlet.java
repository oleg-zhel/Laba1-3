package servlets;

import classes.Client;
import services.DaoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class clientAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoService.clientDAO.save(new Client(0, req.getParameter("myInput1"), req.getParameter("myInput2"),
                req.getParameter("myInput3")));
        DaoService.clientDAO.clientList = DaoService.clientDAO.findAll();
        req.getRequestDispatcher("clientTable.jsp").forward(req,resp);
    }
}
