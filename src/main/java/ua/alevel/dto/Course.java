package ua.alevel.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.alevel.dao.impl.TableDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Course implements Table {
    private static final Logger LOG = LoggerFactory.getLogger(Course.class);

    private int id;
    private String name;
    private Date startDate;
    private int duration;
    private int teacherId;
    private int themeId;

    public Course() {
    }

    public Course(String name, Date startDate, int duration, int teacherId, int themeId) {
        this.setName(name);
        this.setStartDate(startDate);
        this.setDuration(duration);
        this.setTeacherId(teacherId);
        this.setThemeId(themeId);
    }

    public Course(int id, String name, Date startDate, int duration, int teacherId, int themeId) {
        this.setId(id);
        this.setName(name);
        this.setStartDate(startDate);
        this.setDuration(duration);
        this.setTeacherId(teacherId);
        this.setThemeId(themeId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0)
            this.id = id;
        else LOG.warn("Incorrect value Course.id");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            if (!name.isEmpty())
                this.name = name;
            else LOG.warn("Incorrect value Course.name");
        } else LOG.warn("Null value Course.name");
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        if (startDate != null)
            this.startDate = startDate;
        else LOG.warn("Null value Course.startDate");
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration > 0)
            this.duration = duration;
        else LOG.warn("Incorrect value Course.duration");
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        if (teacherId > 0)
            this.teacherId = teacherId;
        else LOG.warn("Incorrect value Course.teacherId");
    }

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        if (themeId > 0)
            this.themeId = themeId;
        else LOG.warn("Incorrect value Course.themeId");
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
