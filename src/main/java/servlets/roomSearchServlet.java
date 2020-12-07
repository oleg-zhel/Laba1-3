package servlets;

import classes.Client;
import classes.Room;
import services.DaoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class roomSearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputValue = req.getParameter("searchInput");
        String inputOption = req.getParameter("searchOption");
        List<Room> roomList;
        try {
            roomList = DaoService.roomDAO.search(inputOption, inputValue);
            DaoService.roomDAO.roomList = roomList;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("clientTable.jsp").forward(req, resp);
    }
}
