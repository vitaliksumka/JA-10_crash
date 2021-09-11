package service_implementation.impl;

import dao.UserDAO;
import dao.impl.UserDaoImpl;
import domain.User_domain;
import org.apache.log4j.Logger;
import service_implementation.*;
import shared.AbstractCRUD;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    private static UserService userServiceImpl;
    private UserDAO userDAO;


    public UserServiceImpl() {
        try {
            userDAO = new UserDaoImpl();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            logger.error(e);
        }
    }

    public static UserService getUserService() {
        if (userServiceImpl == null) {
            userServiceImpl = new UserServiceImpl();
        }
        return userServiceImpl;
    }

    @Override
    public User_domain create(User_domain user_domain) {
        return userDAO.create(user_domain);
    }

    @Override
    public User_domain read(Integer id) {
        return userDAO.read(id);
    }

    @Override
    public User_domain update(User_domain user_domain) {
        return userDAO.update(user_domain);
    }

    @Override
    public void delete(Integer id) {
        userDAO.delete(id);
    }

    @Override
    public List<User_domain> readAll() {
        return userDAO.readAll();
    }

    @Override
    public User_domain getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }
}
