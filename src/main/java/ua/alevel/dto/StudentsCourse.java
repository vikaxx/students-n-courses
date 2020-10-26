package ua.alevel.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentsCourse implements Table {
    private static final Logger LOG = LoggerFactory.getLogger(StudentsCourse.class);

    private int id;
    private String status;
    private int studentId;
    private int courseId;

    public StudentsCourse() {
    }

    public StudentsCourse(int id, String status, int studentId, int courseId) {
        this.id = id;
        this.status = status;
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public StudentsCourse mapResultSetToTableObject(ResultSet resultSet) {
        StudentsCourse current = new StudentsCourse();

        try {
            current.setId(resultSet.getInt("id"));
            current.setCourseId(resultSet.getInt("courseId"));
            current.setStatus(resultSet.getString("status"));
            current.setStudentId(resultSet.getInt("studentId"));
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }

        return current;
    }

    @Override
    public String toString() {
        return "StudentsCourse{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                '}';
    }
}
