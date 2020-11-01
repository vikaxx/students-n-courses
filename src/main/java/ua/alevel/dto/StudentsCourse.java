package ua.alevel.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentsCourse implements Table {
    private static final Logger LOG = LoggerFactory.getLogger(StudentsCourse.class);

    private int id;
    private int studentId;
    private int courseId;

    public StudentsCourse() {
    }

    public StudentsCourse(int studentId, int courseId) {
        this.setStudentId(studentId);
        this.setCourseId(courseId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0)
        this.id = id;
        else LOG.warn("Incorrect value StudentsCourse.id");
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        if (studentId > 0)
        this.studentId = studentId;
        else LOG.warn("Incorrect value StudentsCourse.studentId");
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        if (courseId > 0)
        this.courseId = courseId;
        else LOG.warn("Incorrect value StudentsCourse.courseId");
    }

    @Override
    public StudentsCourse mapResultSetToTableObject(ResultSet resultSet) {
        StudentsCourse current = new StudentsCourse();

        try {
            current.setId(resultSet.getInt("id"));
            current.setCourseId(resultSet.getInt("courseId"));
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
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                '}';
    }
}
