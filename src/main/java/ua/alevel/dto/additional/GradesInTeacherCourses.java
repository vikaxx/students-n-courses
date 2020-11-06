package ua.alevel.dto.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.alevel.dao.impl.TableDaoImpl;
import ua.alevel.dto.Table;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class GradesInTeacherCourses implements Table {
    private static final Logger LOG = LoggerFactory.getLogger(GradesInTeacherCourses.class);

    private int studentCourseId;
    private int mark;

    private String courseName;
    private Date startDate;
    private int duration;
    private int teacherId;
    private int themeId;

    private String firstName;
    private String lastName;
    private boolean isBanned;


    public int getStudentCourseId() {
        return studentCourseId;
    }

    public void setStudentCourseId(int studentCourseId) {
            this.studentCourseId = studentCourseId;
    }
    private int gradeId;


    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public GradesInTeacherCourses() {
    }

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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
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

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

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

    @Override
    public String toString() {
        return "GradesInTeacherCourses{" +
                "gradeId=" + gradeId +
                ", studentCourseId=" + studentCourseId +
                ", mark=" + mark +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", duration=" + duration +
                ", teacherId=" + teacherId +
                ", themeId=" + themeId +
                ", isBanned=" + isBanned +
                '}';
    }
}
