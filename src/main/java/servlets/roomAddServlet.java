package servlets;

import classes.Client;
import classes.Room;
import services.DaoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class roomAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoService.roomDAO.save(new Room(0, req.getParameter("myInput1"), req.getParameter("myInput2"),
                Integer.parseInt(req.getParameter("myInput3"))));
        DaoService.roomDAO.roomList = DaoService.roomDAO.findAll();
        req.getRequestDispatcher("roomTable.jsp").forward(req,resp);
    }
}
