package servlets;

import classes.Reserve;
import classes.Room;
import services.DaoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class reserveAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoService.reserveDAO.save(new Reserve(0, Integer.parseInt(req.getParameter("myInput1")), Integer.parseInt(req.getParameter("myInput2")),
                Integer.parseInt(req.getParameter("myInput3"))));
        DaoService.reserveDAO.reserveList = DaoService.reserveDAO.findAll();
        req.getRequestDispatcher("reserveTable.jsp").forward(req,resp);
    }
}
