package ua.alevel.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Grade implements Table {
    private static final Logger LOG = LoggerFactory.getLogger(Grade.class);

    private int id;
    private int mark;  //////// only from 0 to 100
    private int studentsCourseId;

    public Grade() {
    }

    public Grade(int mark, int studentsCourseId) {
        this.setMark(mark);
        this.setStudentsCourseId(studentsCourseId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0)
        this.id = id;
        else LOG.warn("Incorrect value Grade.id");
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        if (mark > -1 && mark < 101)
        this.mark = mark;
        else LOG.warn("Incorrect value Grade.mark");
    }

    public int getStudentsCourseId() {
        return studentsCourseId;
    }

    public void setStudentsCourseId(int studentsCourseId) {
        if (studentsCourseId > 0)
        this.studentsCourseId = studentsCourseId;
        else LOG.warn("Incorrect value Grade.studentsCourseId");
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
