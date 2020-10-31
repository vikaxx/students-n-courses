package ua.alevel.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.alevel.dao.TableDao;
import ua.alevel.datasource.DataSource;
import ua.alevel.dto.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class TableDaoImpl implements TableDao {
    private static final Logger LOG = LoggerFactory.getLogger(TableDaoImpl.class);
    private DataSource dataSource;

    @Autowired // достать поле из конструктора который предоставляет спринг
    public TableDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public TableDaoImpl() {
    }

    @Override
    public <T extends Table> List<T> selectAllRecordsInTable(String instanceName) { // but not studentsCourse
        List<T> records = new ArrayList<>();
        Class cl = null;
        T table = null;
        try {
            cl = Class.forName("ua.alevel.dto." + instanceName);
        } catch (ClassNotFoundException e) {
            LOG.error("Cannot find class ", e);
        }

        try {
            table = (T) cl.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            LOG.error("Cannot find class ", e);
        }

        try (final Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("Select * from " + instanceName.toLowerCase())) {
            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                records.add((T) table.mapResultSetToTableObject(resultSet));
            }
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }
        return records;
    }
}
