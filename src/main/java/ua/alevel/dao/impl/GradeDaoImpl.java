package ua.alevel.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.alevel.dao.GradeDao;
import ua.alevel.datasource.DataSource;
import ua.alevel.dto.Grade;
import ua.alevel.dto.additional.GradesInTeacherCourses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GradeDaoImpl implements GradeDao {
    private static final Logger LOG = LoggerFactory.getLogger(TableDaoImpl.class);
    private DataSource dataSource;

    @Autowired // достать поле из конструктора который предоставляет спринг
    public GradeDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public GradeDaoImpl() {
    }

    @Override
    public boolean addGrade(Grade grade) {
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO " +
                     "grade (mark, studentsCourseId) VALUES(?, ?)")) {

            ps.setInt(1, grade.getMark());
            ps.setInt(2, grade.getStudentsCourseId());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOG.error("SQL Error", e);
        }
        return false;
    }

    @Override
    public boolean updateGrade(Grade newGrade) {
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE grade " +
                     "SET mark=?, studentsCourseId=? " +
                     "WHERE id=?")) {

            ps.setInt(1, newGrade.getMark());
            ps.setInt(2, newGrade.getStudentsCourseId());
            ps.setInt(3, newGrade.getId());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOG.error("SQL Error", e);
        }
        return false;

    }

    @Override
    public List<GradesInTeacherCourses> selectAllGradesByCourseTeacher(int teacherId) {
        List<GradesInTeacherCourses> courses = new ArrayList<>();
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT c.*, g.mark, s.* " +
                     "FROM course c JOIN studentsCourse sc ON c.id = sc.courseId " +
                     "JOIN grade g on g.studentsCourseId = sc.id join student s on s.id = sc.studentId " +
                     "where c.teacherId = ? order by c.name")) {

            statement.setInt(1, teacherId);
            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                courses.add(new GradesInTeacherCourses().mapResultSetToTableObject(resultSet));
            }
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }
        return courses;
    }
}
