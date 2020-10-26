package ua.alevel.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.OverridingClassLoader;
import org.springframework.stereotype.Component;
import ua.alevel.dao.AdminDao;
import ua.alevel.datasource.DataSource;
import ua.alevel.dto.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class AdminDaoImpl implements AdminDao {
    private static final Logger LOG = LoggerFactory.getLogger(AdminDaoImpl.class);
    private DataSource dataSource;

    @Autowired // достать поле из конструктора который предоставляет спринг
    public AdminDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public AdminDaoImpl() {
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

    @Override
    public List<Course> selectAllCourses() {
        return this.<Course>selectAllRecordsInTable("Course");
    }

    @Override
    public List<Course> selectCoursesByTheme(String themeName) {
        List<Course> courses = new ArrayList<>();
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("Select course.*, theme.name from course join theme " +
                     "on course.themeId = theme.id where theme.name = ?")) {
            statement.setString(1, themeName);
            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                courses.add(new Course().mapResultSetToTableObject(resultSet));
            }
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }
        return courses;
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
    public boolean putTeacherToCourse(int teacherId, int courseId) {
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE course SET teacherId= ? WHERE id= ?")) {

            ps.setInt(1, teacherId);
            ps.setInt(2, courseId);

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOG.error("SQL Error", e);
        }
        return false;
    }

    @Override
    public boolean addNewCourse(Course newCourse) {
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO " +
                     "course (name, startDate, duration, teacherId, themeId) " +
                     "VALUES(?, ?, ?, ?, ?)")) {

            ps.setString(1, newCourse.getName());
            java.sql.Date sqlDate = new java.sql.Date(newCourse.getStartDate().getTime());
            ps.setDate(2, sqlDate);
            ps.setInt(3, newCourse.getDuration());
            ps.setInt(4, newCourse.getTeacherId());
            ps.setInt(5, newCourse.getThemeId());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOG.error("SQL Error", e);
        }
        return false;
    }

    @Override
    public boolean updateCourse(Course course) {
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE course " +
                     "SET name=?, startDate=?, duration=?, " +
                     "teacherId=?, themeId=? WHERE id=?;")) {

            ps.setString(1, course.getName());
            java.sql.Date sqlDate = new java.sql.Date(course.getStartDate().getTime());
            ps.setDate(2, sqlDate);
            ps.setInt(3, course.getDuration());
            ps.setInt(4, course.getTeacherId());
            ps.setInt(5, course.getThemeId());
            ps.setInt(6, course.getId());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOG.error("SQL Error", e);
        }
        return false;
    }

    @Override
    public Course deleteCourse(int courseId) {
        Course deletedCourse = new Course();
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM course " +
                     "WHERE id= ?")) {

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM course WHERE id = \"" + courseId + "\"";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                deletedCourse = new Course().mapResultSetToTableObject(resultSet);
            }

            ps.setInt(1, courseId);
            ps.executeUpdate();

        } catch (SQLException e) {
            LOG.error("SQL Error", e);
        }
        return deletedCourse;
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
