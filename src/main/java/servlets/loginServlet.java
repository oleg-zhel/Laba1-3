package servlets;

import classes.User;
import services.DaoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = DaoService.userDAO.findByLogin(login);

        if (user != null && user.getPassword().equals(password)) {
            req.setAttribute("role", user.getRole());
            req.getRequestDispatcher("chooseTable.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
