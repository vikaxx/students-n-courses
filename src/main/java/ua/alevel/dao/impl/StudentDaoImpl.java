package ua.alevel.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.alevel.dao.StudentDao;
import ua.alevel.datasource.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class StudentDaoImpl implements StudentDao {
    private static final Logger LOG = LoggerFactory.getLogger(TableDaoImpl.class);
    private DataSource dataSource;

    @Autowired // достать поле из конструктора который предоставляет спринг
    public StudentDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public StudentDaoImpl() {
    }

    @Override
    public boolean setStudentBanned(int studentId, boolean banned) {
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE student SET isBanned=? WHERE id=?")) {

            ps.setBoolean(1, banned);
            ps.setInt(2, studentId);

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOG.error("SQL Error", e);
        }
        return false;
    }
}
