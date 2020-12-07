package servlets;

import services.DaoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class clientDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idToDelete = Integer.parseInt(req.getParameter("remove"));
        DaoService.clientDAO.delete(DaoService.clientDAO.getById(idToDelete));
        req.getRequestDispatcher("clientTable.jsp").forward(req, resp);
    }
}
