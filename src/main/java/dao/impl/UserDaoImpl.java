package dao.impl;

import dao.UserDAO;
import domain.User_domain;
import org.apache.log4j.Logger;
import utils.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDAO {

    private static String READ_ALL = "select * from user";
    private static String CREATE = "insert into user(`first_name`, `last_name`, `email`, `role`, `password` ) values (?,?,?,?,?)";
    private static String READ_BY_ID = "select * from user where id =?";
    private static String READ_BY_EMAIL = "select * from user where email=?";
    private static String UPDATE_BY_ID = "update user set email=?, first_name = ?, last_name = ?, role=?, password=?  where id = ?";
    private static String DELETE_BY_ID = "delete from user where id=?";

    private static Logger logger = Logger.getLogger(UserDaoImpl.class);

    private Connection connection;
    private PreparedStatement preparedStatement;


    public UserDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        connection = ConnectionUtils.openConnection();
    }


    @Override
    public User_domain create(User_domain user_domain) {
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user_domain.getEmail());
            preparedStatement.setString(2, user_domain.getFirstName());
            preparedStatement.setString(3, user_domain.getLastName());
            preparedStatement.setString(4, user_domain.getRole());
            preparedStatement.setString(5, user_domain.getPassword());
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            user_domain.setId(rs.getInt(1));
        } catch (SQLException e) {
            logger.error(e);
        }

        return user_domain;
    }

    @Override
    public User_domain read(Integer id) {
        User_domain user_domain = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();

            Integer userId = result.getInt("id");
            String email = result.getString("email");
            String firstName = result.getString("first_name");
            String lastName = result.getString("last_name");
            String role = result.getString("role");
            String password = result.getString("password");
            user_domain = new User_domain(userId, email, firstName, lastName, role, password);

        } catch (SQLException e) {
            logger.error(e);
        }

        return user_domain;
    }

    @Override
    public User_domain update(User_domain user_domain) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, user_domain.getEmail());
            preparedStatement.setString(2, user_domain.getFirstName());
            preparedStatement.setString(3, user_domain.getLastName());
            preparedStatement.setString(4, user_domain.getRole());
            preparedStatement.setString(5, user_domain.getPassword());
            preparedStatement.setInt(6, user_domain.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
        }

        return user_domain;
    }

    @Override
    public void delete(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    @Override
    public List<User_domain> readAll() {
        List<User_domain> userRecords = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {

            }
            Integer userId = result.getInt("id");
            String email = result.getString("email");
            String firstName = result.getString("first_name");
            String lastName = result.getString("last_name");
            String role = result.getString("role");
            String password = result.getString("password");
            userRecords.add(new User_domain(userId, email, firstName, lastName, role, password));
        } catch (SQLException e) {
            logger.error(e);
        }

        return userRecords;

    }

    @Override
    public User_domain getUserByEmail(String email) {
        User_domain user_domain = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet result = preparedStatement.executeQuery();
            result.next();

            Integer userId = result.getInt("id");
            String firstName = result.getString("first_name");
            String lastName = result.getString("last_name");
            String role = result.getString("role");
            String password = result.getString("password");
            user_domain = new User_domain(userId, email, firstName, lastName, role, password);

        } catch (SQLException e) {
            logger.error(e);
        }

        return user_domain;

    }

}
