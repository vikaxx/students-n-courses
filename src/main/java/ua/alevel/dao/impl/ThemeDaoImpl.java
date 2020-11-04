package ua.alevel.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.alevel.dao.ThemeDao;
import ua.alevel.datasource.DataSource;
import ua.alevel.dto.Theme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ThemeDaoImpl implements ThemeDao {
    private static final Logger LOG = LoggerFactory.getLogger(ThemeDaoImpl.class);
    private DataSource dataSource;

    @Autowired // достать поле из конструктора который предоставляет спринг
    public ThemeDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ThemeDaoImpl() {
    }

    @Override
    public List<Theme> selectAllThemes() {
        List<Theme> records = new ArrayList<>();
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("Select * from theme")) {
            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                records.add(new Theme().mapResultSetToTableObject(resultSet));
            }
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }
        return records;
    }
}
