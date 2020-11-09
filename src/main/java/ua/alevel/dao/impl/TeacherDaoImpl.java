package ua.alevel.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.alevel.dao.TeacherDao;
import ua.alevel.datasource.DataSource;
import ua.alevel.dto.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherDaoImpl implements TeacherDao {
    private static final Logger LOG = LoggerFactory.getLogger(TeacherDaoImpl.class);
    private DataSource dataSource;

    @Autowired
    public TeacherDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public TeacherDaoImpl() {
    }

    @Override
    public boolean addNewTeacher(Teacher newTeacher) {
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO " +
                     "teacher (firstName, lastName) " +
                     "VALUES(?, ?)")) {

            ps.setString(1, newTeacher.getFirstName());
            ps.setString(2, newTeacher.getLastName());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOG.error("SQL Error", e);
        }
        return false;
    }

    @Override
    public List<Teacher> selectAllTeachers() {
        List<Teacher> records = new ArrayList<>();
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("Select * from teacher")) {
            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                records.add(new Teacher().mapResultSetToTableObject(resultSet));
            }
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }
        return records;
    }
}
