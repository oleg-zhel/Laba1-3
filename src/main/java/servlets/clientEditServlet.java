package servlets;

import classes.Client;
import services.DaoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class clientEditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idToEdit = Integer.parseInt(req.getParameter("idToEdit"));
        Client clientToEdit = DaoService.clientDAO.getById(idToEdit);
        clientToEdit.setFirstName(req.getParameter("myInput1"));
        clientToEdit.setSecondName(req.getParameter("myInput2"));
        clientToEdit.setPhoneNumber(req.getParameter("myInput3"));
        DaoService.clientDAO.update(clientToEdit);
        req.getRequestDispatcher("clientTable.jsp").forward(req,resp);
    }
}
