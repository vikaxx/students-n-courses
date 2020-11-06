package ua.alevel.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.alevel.dao.GradeDao;
import ua.alevel.datasource.DataSource;
import ua.alevel.dto.Grade;
import ua.alevel.dto.additional.GradeToBeAdded;
import ua.alevel.dto.additional.GradesInTeacherCourses;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
public class GradeDaoImpl implements GradeDao {
    private static final Logger LOG = LoggerFactory.getLogger(GradeDaoImpl.class);
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
        } catch (SQLIntegrityConstraintViolationException e) {
            return false;
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
                     "WHERE id=? ")) {

            ps.setInt(1, newGrade.getMark());

            PreparedStatement statement = connection.prepareStatement("select studentsCourseId " +
                    "from grade where id = ?");
            statement.setInt(1, newGrade.getId());
            int studentsCourseId = 0;
            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                studentsCourseId = resultSet.getInt(1);
            }
            ps.setInt(2, studentsCourseId);
            ps.setInt(3, newGrade.getId());
            statement.close();
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
             PreparedStatement statement = connection.prepareStatement("SELECT c.*, g.mark, g.id AS gradeId, s.*, sc.id AS scid " +
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

    @Override
    public List<GradeToBeAdded> selectNotGradedStudentsCourses(int teacherId) {
        List<GradeToBeAdded> result = new ArrayList<>();
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT c.startDate AS startDate, c.duration, sc.id as scid, c.name as courseName," +
                     " s.firstName, s.lastName, g.mark FROM course c JOIN studentsCourse sc " +
                     "on c.id = sc.courseId JOIN student s on s.id = sc.studentId " +
                     "left join grade g on g.studentsCourseId = sc.id " +
                     "WHERE g.mark is null and teacherId = ?")) {

            statement.setInt(1, teacherId);
            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                GradeToBeAdded gradeToBeAdded = new GradeToBeAdded();
                gradeToBeAdded = gradeToBeAdded.mapResultSetToTableObject(resultSet);
                java.util.Date date = new java.util.Date();
                Calendar today = Calendar.getInstance();
                today.setTime(date);

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(gradeToBeAdded.getStartDate());
                if (calendar.after(today)) { // не начался
                } else {
                    calendar.roll(Calendar.MONTH, gradeToBeAdded.getDuration());
                    if (calendar.get(Calendar.MONTH) < gradeToBeAdded.getDuration()) {
                        calendar.roll(Calendar.YEAR, gradeToBeAdded.getDuration() / 12 + 1);
                    }
                    if (today.before(calendar)) { // начался
                    } else result.add(gradeToBeAdded);
                }
            }
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }
        return result;
    }

}
