package services;

import DAO.ClientDAO;
import DAO.ReserveDAO;
import DAO.RoomDAO;
import DAO.UserDAO;

public class DaoService {
    public static ClientDAO clientDAO = new ClientDAO();
    public static ReserveDAO reserveDAO = new ReserveDAO();
    public static RoomDAO roomDAO = new RoomDAO();
    public static UserDAO userDAO = new UserDAO();
}
