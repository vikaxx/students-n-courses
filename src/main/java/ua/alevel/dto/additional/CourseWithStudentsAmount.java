package ua.alevel.dto.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.alevel.dao.impl.TableDaoImpl;
import ua.alevel.dto.Table;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class CourseWithStudentsAmount implements Table {
    private static final Logger LOG = LoggerFactory.getLogger(CourseWithStudentsAmount.class);

    private int id;
    private String name;
    private Date startDate;
    private int duration;
    private int teacherId;
    private int themeId;
    private int studentsAmount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getStudentsAmount() {
        return studentsAmount;
    }

    public void setStudentsAmount(int studentsAmount) {
        this.studentsAmount = studentsAmount;
    }

    public CourseWithStudentsAmount(int id, String name, Date startDate, int duration, int teacherId, int themeId, int studentsAmount) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.duration = duration;
        this.teacherId = teacherId;
        this.themeId = themeId;
        this.studentsAmount = studentsAmount;
    }

    public CourseWithStudentsAmount() {
    }

    @Override
    public String toString() {
        return "CourseWithStudentsAmount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", duration=" + duration +
                ", teacherId=" + teacherId +
                ", themeId=" + themeId +
                ", studentsAmount=" + studentsAmount +
                '}';
    }

    @Override
    public CourseWithStudentsAmount mapResultSetToTableObject(ResultSet resultSet) {
        CourseWithStudentsAmount current = new CourseWithStudentsAmount();

        try {
            current.setId(resultSet.getInt("id"));
            current.setName(resultSet.getString("name"));
            current.setStartDate(resultSet.getDate("startDate"));
            current.setDuration(resultSet.getInt("duration"));
            current.setTeacherId(resultSet.getInt("teacherId"));
            current.setThemeId(resultSet.getInt("themeId"));
            current.setStudentsAmount(resultSet.getInt("quantity_students"));
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }

        return current;
    }
}
