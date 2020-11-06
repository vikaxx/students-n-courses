package ua.alevel.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.alevel.dao.StudentsCourseDao;
import ua.alevel.datasource.DataSource;
import ua.alevel.dto.StudentsCourse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class StudentsCourseDaoImpl implements StudentsCourseDao {
    private static final Logger LOG = LoggerFactory.getLogger(StudentsCourseDaoImpl.class);
    private DataSource dataSource;

    @Autowired // достать поле из конструктора который предоставляет спринг
    public StudentsCourseDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public StudentsCourseDaoImpl() {
    }

    @Override
    public boolean addStudentToCourse(StudentsCourse studentsCourse) {
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO studentsCourse (studentId, courseId) " +
                     "VALUES(?, ?)")) {

            ps.setInt(1, studentsCourse.getStudentId());
            ps.setInt(2, studentsCourse.getCourseId());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOG.error("SQL Error", e);
        }
        return false;
    }
}
