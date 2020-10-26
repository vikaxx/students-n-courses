package ua.alevel.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Grade implements Table {
    private static final Logger LOG = LoggerFactory.getLogger(Grade.class);

    private int id;
    private int mark;
    private int studentsCourseId;

    public Grade() {
    }

    public Grade(int id, int mark, int studentsCourseId) {
        this.id = id;
        this.mark = mark;
        this.studentsCourseId = studentsCourseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getStudentsCourseId() {
        return studentsCourseId;
    }

    public void setStudentsCourseId(int studentsCourseId) {
        this.studentsCourseId = studentsCourseId;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", mark=" + mark +
                ", studentsCourseId=" + studentsCourseId +
                '}';
    }

    @Override
    public Grade mapResultSetToTableObject(ResultSet resultSet) {
        Grade current = new Grade();

        try {
            current.setId(resultSet.getInt("id"));
            current.setMark(resultSet.getInt("mark"));
            current.setStudentsCourseId(resultSet.getInt("studentsCourseId"));
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }

        return current;
    }
}
