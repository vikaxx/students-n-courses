package ua.alevel.dto.additional;

/**
 * Class that shows students that do not have grade for specific teacher courses
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

public class GradeToBeAdded implements Table {

    /**
     * Field of logging events or errors
     */
    private static final Logger LOG = LoggerFactory.getLogger(GradeToBeAdded.class);

    /**
     * Field of specific student's course id
     */
    private int studentCourseId;

    /**
     * Field of course name
     */
    private String courseName;

    /**
     * Field of course start date
     */
    private Date startDate;

    /**
     * Field of student first name
     */
    private String firstName;

    /**
     * Field of student last name
     */
    private String lastName;

    /**
     * Field of course duration
     */
    private int duration;

    /**
     * Initializes a newly created empty {@code GradeToBeAdded} object
     *
     * @see GradeToBeAdded#GradeToBeAdded(int, String, Date, String, String, int)
     */
    public GradeToBeAdded() {
    }

    /**
     * Initializes a newly created {@code GradeToBeAdded} object
     *
     * @param courseName      name of course
     * @param studentCourseId id of student's course
     * @param startDate       start date of course
     * @param duration        duration of course in months
     * @param firstName       first name of student
     * @param lastName        last name of student
     * @see GradeToBeAdded#GradeToBeAdded()
     */
    public GradeToBeAdded(int studentCourseId, String courseName, Date startDate, String firstName, String lastName, int duration) {
        this.studentCourseId = studentCourseId;
        this.courseName = courseName;
        this.startDate = startDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.duration = duration;
    }

    /**
     * Returns a number representing {@link GradeToBeAdded#duration} of {@code Course} in db
     * The value returned will be greater than 0
     * The value means quantity of month of course duration
     *
     * @return duration of course
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets a number representing {@link GradeToBeAdded#duration} of {@code Course} in db
     * The value should be greater than 0
     * The value means quantity of month of course duration
     *
     * @param duration duration of course
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Returns a number representing {@link GradeToBeAdded#studentCourseId} of {@code GradesInTeacherCourses} in db
     * The value will be greater than 0
     *
     * @return id of student's course
     */
    public int getStudentCourseId() {
        return studentCourseId;
    }

    /**
     * Sets a number representing {@link GradeToBeAdded#studentCourseId} of {@code StudentCourse} in db
     * The value should be greater than 0
     *
     * @param studentCourseId id of student's course
     */
    public void setStudentCourseId(int studentCourseId) {
        this.studentCourseId = studentCourseId;
    }

    /**
     * Returns a string representing {@link GradeToBeAdded#courseName} of {@code Course} in db
     *
     * @return name of course
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets a string representing {@link GradeToBeAdded#courseName} of {@code Course} in db
     *
     * @param courseName name of course
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Returns a date representing {@link GradeToBeAdded#startDate} of {@code Course} in db
     * The value returned will be have format yyyy-MM-dd
     *
     * @return start date of course
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets a date representing {@link GradeToBeAdded#startDate} of {@code Course} in db
     * The value should have format yyyy-MM-dd
     *
     * @param startDate start date of course
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Returns a string representing {@link GradeToBeAdded#firstName} of {@code Student} in db
     *
     * @return first name of this student
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets a string representing {@link GradeToBeAdded#firstName} of {@code Student} in db
     *
     * @param firstName first name of student
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns a string representing {@link GradeToBeAdded#lastName} of {@code Student} in db
     *
     * @return last name of student
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets a string representing {@link GradeToBeAdded#lastName} of {@code Student} in db
     *
     * @param lastName first name of student
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Initializes a {@code GradeToBeAdded} object according to data that was taken from db
     *
     * @param resultSet data from db
     * @return new {@code GradeToBeAdded} object
     */
    @Override
    public GradeToBeAdded mapResultSetToTableObject(ResultSet resultSet) {
        GradeToBeAdded current = new GradeToBeAdded();

        try {
            current.setStudentCourseId(resultSet.getInt("scid"));
            current.setCourseName(resultSet.getString("courseName"));
            current.setStartDate(resultSet.getDate("startDate"));

            current.setFirstName(resultSet.getString("firstName"));
            current.setLastName(resultSet.getString("lastName"));
            current.setDuration(resultSet.getInt("duration"));
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }

        return current;
    }

    /**
     * Converts this {@code GradeToBeAdded} object to a {@code String} object
     *
     * @return {@code String} object equals to {@code GradeToBeAdded} object by values
     */
    @Override
    public String toString() {
        return "GradeToBeAdded{" +
                "studentCourseId=" + studentCourseId +
                ", courseName='" + courseName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
