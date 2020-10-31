package ua.alevel.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.alevel.dao.CourseDao;
import ua.alevel.dao.TableDao;
import ua.alevel.datasource.DataSource;
import ua.alevel.dto.Course;
import ua.alevel.dto.additional.CourseWithStudentsAmount;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Component
public class CourseDaoImpl extends TableDaoImpl implements CourseDao {
    private static final Logger LOG = LoggerFactory.getLogger(CourseDaoImpl.class);
    private DataSource dataSource;

    @Autowired // достать поле из конструктора который предоставляет спринг
    public CourseDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public CourseDaoImpl() {
    }

    @Override
    public List<Course> selectAllCourses() {
        return super.<Course>selectAllRecordsInTable("Course");
    }

    private List<Course> selectAllCoursesWithOrder(String orderByDirection) {
        List<Course> records = new ArrayList<>();
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("Select * from courses ORDER BY name " + orderByDirection)) {
            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                records.add(new Course().mapResultSetToTableObject(resultSet));
            }
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }
        return records;

    }

    @Override
    public List<Course> selectAllCoursesAZ() {
        return selectAllCoursesWithOrder("ASC");
    }

    @Override
    public List<Course> selectAllCoursesZA() {
        return selectAllCoursesWithOrder("DESC");
    }

    @Override
    public List<Course> selectCoursesSortedByDuration(String orderByDirection) {
        List<Course> courses = new ArrayList<>();
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM course " +
                     "ORDER BY duration " + orderByDirection)) {
            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                courses.add(new Course().mapResultSetToTableObject(resultSet));
            }
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }
        return courses;
    }

    @Override ////// добавить сущность курс + кол-во его студентов
    public List<CourseWithStudentsAmount> selectCoursesSortedByStudentsQuantity(String orderByDirection) {
        List<CourseWithStudentsAmount> courses = new ArrayList<>();
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT c.*, COUNT(s.id) AS quantity_students " +
                     "FROM course c JOIN studentsCourse sc ON c.id = sc.courseId " +
                     "JOIN student s ON s.id = sc.studentId GROUP BY c.id " +
                     "ORDER BY quantity_students " + orderByDirection)) {
            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                courses.add(new CourseWithStudentsAmount().mapResultSetToTableObject(resultSet));
            }
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }
        return courses;
    }

    @Override
    public List<Course> selectCoursesByTheme(String theme) {
        List<Course> courses = new ArrayList<>();
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("Select course.*, theme.name from course join theme " +
                     "on course.themeId = theme.id where theme.name = ?")) {
            statement.setString(1, theme);
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
    public List<Course> selectCoursesByTeacher(int teacherId) {
        List<Course> courses = new ArrayList<>();
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT c.*,t.* FROM course c " +
                     "JOIN teacher t ON c.teacherId = t.id WHERE t.id = ?")) {
            statement.setInt(1, teacherId);
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

    private List<Course> selectAllCoursesByStudent(int studentId) {
        List<Course> courses = new ArrayList<>();
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT c.* FROM course c " +
                     "JOIN studentsCourse sc ON c.id = sc.courseId " +
                     "JOIN student s ON s.id = sc.studentId WHERE s.id = ?")) {
            statement.setInt(1, studentId);
            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                /// делать проверку на то как соотносится дата в выборке с текущей датой
                //    и на основе этого добавлять в финальный сет или нет
                //    вынести в отдельный метод.
                courses.add(new Course().mapResultSetToTableObject(resultSet));
            }
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }
        return courses;
    }

    @Override
    public List<Course> selectNotStartedCoursesByStudent(int studentId) {
        List<Course> courses = selectAllCoursesByStudent(studentId);
        List<Course> result = new ArrayList<>();
        java.util.Date date = new java.util.Date();

        for (Course current : courses) {
            if (current.getStartDate().after(date)) {
                result.add(current);
            }
        }
        return result;
    }

    @Override
    public List<Course> selectStartedCoursesByStudent(int studentId) {
        List<Course> courses = selectAllCoursesByStudent(studentId);
        List<Course> result = new ArrayList<>();
        java.util.Date date = new java.util.Date();
        Calendar today = Calendar.getInstance();
        today.setTime(date);

        for (Course current : courses) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(current.getStartDate());
            calendar.roll(Calendar.MONTH, current.getDuration());
            if (today.before(calendar)) {
                result.add(current);
            }
        }
        return result;
    }

    @Override
    public List<Course> selectEndedCoursesByStudent(int studentId) {
        List<Course> courses = selectAllCoursesByStudent(studentId);
        List<Course> result = new ArrayList<>();
        java.util.Date date = new java.util.Date();
        Calendar today = Calendar.getInstance();
        today.setTime(date);

        for (Course current : courses) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(current.getStartDate());
            calendar.roll(Calendar.MONTH, current.getDuration());
            if (today.after(calendar)) {
                result.add(current);
            }
        }
        return result;
    }
}
