package servlets;

import services.DaoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class roomDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idToDelete = Integer.parseInt(req.getParameter("remove"));
        DaoService.roomDAO.delete(DaoService.roomDAO.getById(idToDelete));
        req.getRequestDispatcher("roomTable.jsp").forward(req, resp);
    }
}
