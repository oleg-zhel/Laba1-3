package servlets;

import classes.Client;
import classes.Room;
import services.DaoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class roomEditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idToEdit = Integer.parseInt(req.getParameter("idToEdit"));
        Room roomToEdit = DaoService.roomDAO.getById(idToEdit);
        roomToEdit.setLocation(req.getParameter("myInput1"));
        roomToEdit.setNumber(req.getParameter("myInput2"));
        roomToEdit.setPrice(Integer.parseInt(req.getParameter("myInput3")));
        DaoService.roomDAO.update(roomToEdit);
        req.getRequestDispatcher("roomTable.jsp").forward(req,resp);
    }
}
