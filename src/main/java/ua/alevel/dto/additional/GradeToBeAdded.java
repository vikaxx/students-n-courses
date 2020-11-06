package ua.alevel.dto.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.alevel.dto.Table;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class GradeToBeAdded implements Table {
    private static final Logger LOG = LoggerFactory.getLogger(GradeToBeAdded.class);

    private int studentCourseId;

    private String courseName;
    private Date startDate;

    private String firstName;
    private String lastName;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    private int duration;

    public GradeToBeAdded() {
    }

    public GradeToBeAdded(int studentCourseId, String courseName, Date startDate, String firstName, String lastName, int duration) {
        this.studentCourseId = studentCourseId;
        this.courseName = courseName;
        this.startDate = startDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "GradeToBeAdded{" +
                "studentCourseId=" + studentCourseId +
                ", courseName='" + courseName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public int getStudentCourseId() {
        return studentCourseId;
    }

    public void setStudentCourseId(int studentCourseId) {
        this.studentCourseId = studentCourseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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
}
