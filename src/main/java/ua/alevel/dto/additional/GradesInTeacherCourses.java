package ua.alevel.dto.additional;

/**
 * Class that shows students grades for specific teacher courses
 * This class is used to create objects of merged tables
 *
 * @autor Victoria Aliaeva
 * @version 1.0
 * @since 2020-11-01
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.alevel.dto.Table;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class GradesInTeacherCourses implements Table {

    /**
     * Field of logging events or errors
     */
    private static final Logger LOG = LoggerFactory.getLogger(GradesInTeacherCourses.class);

    /**
     * Field of {@code GradesInTeacherCourses} specific student's course id
     */
    private int studentCourseId;

    /**
     * Field of {@code GradesInTeacherCourses} mark
     * Should be from 0 to 100
     */
    private int mark;

    /**
     * Field of course name
     */
    private String courseName;

    /**
     * Field of course start date
     */
    private Date startDate;

    /**
     * Field of course duration
     */
    private int duration;

    /**
     * Field of course teacher id
     */
    private int teacherId;

    /**
     * Field of course theme id
     */
    private int themeId;

    /**
     * Field of student first name
     */
    private String firstName;

    /**
     * Field of student last name
     */
    private String lastName;

    /**
     * Field of info is student banned
     */
    private boolean isBanned;

    /**
     * Field of student's grade id
     */
    private int gradeId;

    /**
     * Initializes a newly created empty {@code GradesInTeacherCourses} object
     *
     * @see GradesInTeacherCourses#GradesInTeacherCourses(int, int, int, String, Date, int, int, int, String, String, boolean)
     */
    public GradesInTeacherCourses() {
    }

    /**
     * Initializes a newly created {@code GradesInTeacherCourses} object
     *
     * @param gradeId         id of student's grade
     * @param courseName      name of course
     * @param mark            mark of student's course
     * @param studentCourseId id of student's course
     * @param startDate       start date of course
     * @param duration        duration of course in months
     * @param teacherId       id of teacher of course
     * @param themeId         id of theme of course
     * @param firstName       first name of student
     * @param lastName        last name of student
     * @param isBanned        info is student banned
     * @see GradesInTeacherCourses#GradesInTeacherCourses()
     */
    public GradesInTeacherCourses(int gradeId, int studentCourseId, int mark, String courseName, Date startDate, int duration, int teacherId, int themeId, String firstName, String lastName, boolean isBanned) {
        this.gradeId = gradeId;
        this.studentCourseId = studentCourseId;
        this.mark = mark;
        this.courseName = courseName;
        this.startDate = startDate;
        this.duration = duration;
        this.teacherId = teacherId;
        this.themeId = themeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isBanned = isBanned;
    }

    /**
     * Returns a number representing {@link GradesInTeacherCourses#studentCourseId} of {@code GradesInTeacherCourses} in db
     * The value will be greater than 0
     *
     * @return id of student's course
     */
    public int getStudentCourseId() {
        return studentCourseId;
    }

    /**
     * Sets a number representing {@link GradesInTeacherCourses#studentCourseId} of {@code StudentCourse} in db
     * The value should be greater than 0
     *
     * @param studentCourseId id of student's course
     */
    public void setStudentCourseId(int studentCourseId) {
        this.studentCourseId = studentCourseId;
    }

    /**
     * Returns a number representing {@link GradesInTeacherCourses#gradeId} of {@code Grade} in db
     * The value returned will be greater than 0
     *
     * @return id of student's grade
     */
    public int getGradeId() {
        return gradeId;
    }

    /**
     * Sets a number representing {@link GradesInTeacherCourses#gradeId} of {@code Grade} in db
     * The value should be greater than 0
     *
     * @param gradeId id of student's grade
     */
    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    /**
     * Returns a number representing {@link GradesInTeacherCourses#mark} of {@code Grade} in db
     * The value returned will be from 0 to 100
     *
     * @return mark of student course
     */
    public int getMark() {
        return mark;
    }

    /**
     * Sets a number representing {@link GradesInTeacherCourses#mark} of {@code Grade} in db
     * The value returned will be from 0 to 100
     *
     * @param mark mark of student course
     */
    public void setMark(int mark) {
        this.mark = mark;
    }

    /**
     * Returns a string representing {@link GradesInTeacherCourses#courseName} of {@code Course} in db
     *
     * @return name of course
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets a string representing {@link GradesInTeacherCourses#courseName} of {@code Course} in db
     *
     * @param courseName name of course
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Returns a date representing {@link GradesInTeacherCourses#startDate} of {@code Course} in db
     * The value returned will be have format yyyy-MM-dd
     *
     * @return start date of course
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets a date representing {@link GradesInTeacherCourses#startDate} of {@code Course} in db
     * The value should have format yyyy-MM-dd
     *
     * @param startDate start date of course
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Returns a number representing {@link GradesInTeacherCourses#duration} of {@code Course} in db
     * The value returned will be greater than 0
     * The value means quantity of month of course duration
     *
     * @return duration of course
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets a number representing {@link GradesInTeacherCourses#duration} of {@code Course} in db
     * The value should be greater than 0
     * The value means quantity of month of course duration
     *
     * @param duration duration of course
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Returns a number representing {@link GradesInTeacherCourses#teacherId} of {@code Course} in db
     * The value returned will be greater than 0
     *
     * @return id of teacher of course
     */
    public int getTeacherId() {
        return teacherId;
    }

    /**
     * Sets a number representing {@link GradesInTeacherCourses#teacherId} of {@code Course} in db
     * The value should be greater than 0
     *
     * @param teacherId id of teacher of course
     */
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * Returns a number representing {@link GradesInTeacherCourses#themeId} of {@code Course} in db
     * The value returned will be greater than 0
     *
     * @return id of theme of course
     */
    public int getThemeId() {
        return themeId;
    }

    /**
     * Sets a number representing {@link GradesInTeacherCourses#themeId} of {@code Course} in db
     * The value should be greater than 0
     *
     * @param themeId id of theme of course
     */
    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    /**
     * Returns a string representing {@link GradesInTeacherCourses#firstName} of {@code Student} in db
     *
     * @return first name of this student
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets a string representing {@link GradesInTeacherCourses#firstName} of {@code Student} in db
     *
     * @param firstName first name of student
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns a string representing {@link GradesInTeacherCourses#lastName} of {@code Student} in db
     *
     * @return last name of student
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets a string representing {@link GradesInTeacherCourses#lastName} of {@code Student} in db
     *
     * @param lastName first name of student
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns a boolean representing {@link GradesInTeacherCourses#isBanned} of {@code Student} in db
     * Returned value "true" means that student is banned
     * Returned value "false" means that student is not banned
     *
     * @return true or false
     */
    public boolean isBanned() {
        return isBanned;
    }

    /**
     * Sets a boolean representing {@link GradesInTeacherCourses#isBanned} of {@code Student} in db
     * Value "true" means that student is banned
     * Value "false" means that student is not banned
     *
     * @param banned info is student banned
     */
    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    /**
     * Initializes a {@code GradesInTeacherCourses} object according to data that was taken from db
     *
     * @param resultSet data from db
     * @return new {@code GradesInTeacherCourses} object
     */
    @Override
    public GradesInTeacherCourses mapResultSetToTableObject(ResultSet resultSet) {
        GradesInTeacherCourses current = new GradesInTeacherCourses();

        try {
            current.setGradeId(resultSet.getInt("gradeId"));
            current.setStudentCourseId(resultSet.getInt("scid"));
            current.setCourseName(resultSet.getString("name"));
            current.setStartDate(resultSet.getDate("startDate"));
            current.setDuration(resultSet.getInt("duration"));
            current.setTeacherId(resultSet.getInt("teacherId"));
            current.setThemeId(resultSet.getInt("themeId"));

            current.setFirstName(resultSet.getString("firstName"));
            current.setLastName(resultSet.getString("lastName"));
            current.setBanned(resultSet.getBoolean("isBanned"));

            current.setMark(resultSet.getInt("mark"));
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }

        return current;
    }

    /**
     * Converts this {@code GradesInTeacherCourses} object to a {@code String} object
     *
     * @return {@code String} object equals to {@code GradesInTeacherCourses} object by values
     */
    @Override
    public String toString() {
        return "GradesInTeacherCourses{" +
                "gradeId=" + gradeId +
                ", mark=" + mark +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
