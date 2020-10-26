package ua.alevel.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.alevel.dao.impl.AdminDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Course implements Table {
    private static final Logger LOG = LoggerFactory.getLogger(AdminDaoImpl.class);

    private int id;
    private String name;
    private Date startDate;
    private int duration;
    private int teacherId;
    private int themeId;

    public Course() {
    }

    public Course(String name, Date startDate, int duration, int teacherId, int themeId) {
        this.name = name;
        this.startDate = startDate;
        this.duration = duration;
        this.teacherId = teacherId;
        this.themeId = themeId;
    }

    public Course(int id, String name, Date startDate, int duration, int teacherId, int themeId) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.duration = duration;
        this.teacherId = teacherId;
        this.themeId = themeId;
    }

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

    @Override
    public Course mapResultSetToTableObject(ResultSet resultSet) {
        Course current = new Course();

        try {
            current.setId(resultSet.getInt("id"));
            current.setName(resultSet.getString("name"));
            current.setStartDate(resultSet.getDate("startDate"));
            current.setDuration(resultSet.getInt("duration"));
            current.setTeacherId(resultSet.getInt("teacherId"));
            current.setThemeId(resultSet.getInt("themeId"));
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }

        return current;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", duration=" + duration +
                ", teacherId=" + teacherId +
                ", themeId=" + themeId +
                '}';
    }
}
