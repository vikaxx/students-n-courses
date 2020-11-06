package ua.alevel.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.alevel.dao.StudentDao;
import ua.alevel.datasource.DataSource;
import ua.alevel.dto.Course;
import ua.alevel.dto.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoImpl implements StudentDao {
    private static final Logger LOG = LoggerFactory.getLogger(StudentDaoImpl.class);
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

    @Override
    public boolean isStudentBanned(int studentId) {
        boolean isBanned = false;
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT isBanned FROM student where id = ?")) {
            statement.setInt(1, studentId);
            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                isBanned = resultSet.getBoolean("isBanned");
            }
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }
        return isBanned;
    }

    @Override
    public List<Student> selectAllStudents() {
        List<Student> records = new ArrayList<>();
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("Select * from student")) {
            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                records.add(new Student().mapResultSetToTableObject(resultSet));
            }
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }
        return records;
    }
}
