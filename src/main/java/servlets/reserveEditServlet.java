package servlets;

import classes.Client;
import classes.Reserve;
import services.DaoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class reserveEditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idToEdit = Integer.parseInt(req.getParameter("idToEdit"));
        Reserve reserveToEdit = DaoService.reserveDAO.getById(idToEdit);
        reserveToEdit.setIdClient(Integer.parseInt(req.getParameter("myInput1")));
        reserveToEdit.setIdRoom(Integer.parseInt(req.getParameter("myInput2")));
        reserveToEdit.setLength(Integer.parseInt(req.getParameter("myInput3")));
        DaoService.reserveDAO.update(reserveToEdit);
        req.getRequestDispatcher("reserveTable.jsp").forward(req, resp);
    }
}
