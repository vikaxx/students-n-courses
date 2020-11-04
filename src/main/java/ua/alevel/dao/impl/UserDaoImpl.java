package ua.alevel.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.alevel.dao.UserDao;
import ua.alevel.datasource.DataSource;
import ua.alevel.dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserDaoImpl implements UserDao {
    private static final Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class);
    private DataSource dataSource;

    @Autowired // достать поле из конструктора который предоставляет спринг
    public UserDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public UserDaoImpl() {
    }

    @Override
    public User selectUserByLogin(String login) {
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM `user` where login = ?")) {
            statement.setString(1, login);
            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return new User().mapResultSetToTableObject(resultSet);
            }
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }
        return null;
    }
}
