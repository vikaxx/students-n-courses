package ua.alevel.dto;

/**
 * Class corresponding to db table course
 *
 * @autor Victoria Aliaeva
 * @version 1.0
 * @since 2020-11-01
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Course implements Table {

    /**
     * Field of logging events or errors
     */
    private static final Logger LOG = LoggerFactory.getLogger(Course.class);

    /**
     * Field of {@code Course} id
     */
    private int id;

    /**
     * Field of {@code Course} name
     */
    private String name;

    /**
     * Field of {@code Course} start date
     */
    private Date startDate;

    /**
     * Field of {@code Course} duration
     */
    private int duration;

    /**
     * Field of {@code Course} teacher id
     */
    private int teacherId;

    /**
     * Field of {@code Course} theme id
     */
    private int themeId;

    /**
     * Initializes a newly created empty {@code Course} object
     *
     * @see Course#Course(String, Date, int, int, int)
     * @see Course#Course(int, String, Date, int, int, int)
     */
    public Course() {
    }

    /**
     * Initializes a newly created {@code Course} object
     *
     * @param name      name of {@code Course}
     * @param startDate start date of {@code Course}
     * @param duration  duration of {@code Course} in months
     * @param teacherId id of teacher of {@code Course} - foreign key in db
     * @param themeId   id of theme of {@code Course} - foreign key in db
     * @see Course#Course()
     * @see Course#Course(int, String, Date, int, int, int)
     */
    public Course(String name, Date startDate, int duration, int teacherId, int themeId) {
        this.setName(name);
        this.setStartDate(startDate);
        this.setDuration(duration);
        this.setTeacherId(teacherId);
        this.setThemeId(themeId);
    }

    /**
     * Initializes a newly created {@code Course} object
     *
     * @param id        id of {@code Course} - primary key in db, generated automatically
     * @param name      name of {@code Course}
     * @param startDate start date of {@code Course}
     * @param duration  duration of {@code Course} in months
     * @param teacherId id of teacher of {@code Course} - foreign key in db
     * @param themeId   id of theme of {@code Course} - foreign key in db
     * @see Course#Course()
     * @see Course#Course(int, String, Date, int, int, int)
     */
    public Course(int id, String name, Date startDate, int duration, int teacherId, int themeId) {
        this.setId(id);
        this.setName(name);
        this.setStartDate(startDate);
        this.setDuration(duration);
        this.setTeacherId(teacherId);
        this.setThemeId(themeId);
    }

    /**
     * Returns a number representing {@link Course#id} of {@code Course} in db
     * The value returned will be greater than 0
     *
     * @return id of this course
     */
    public int getId() {
        return id;
    }

    /**
     * Sets a number representing {@link Course#id} of {@code Course} in db
     * The value should be greater than 0
     *
     * @param id id of {@code Course} - primary key in db, generated automatically
     */
    public void setId(int id) {
        if (id > 0)
            this.id = id;
        else LOG.warn("Incorrect value Course.id");
    }

    /**
     * Returns a string representing {@link Course#name} of {@code Course} in db
     *
     * @return name of this course
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a string representing {@link Course#name} of {@code Course} in db
     *
     * @param name name of {@code Course}
     */
    public void setName(String name) {
        if (name != null) {
            if (!name.isEmpty())
                this.name = name;
            else LOG.warn("Incorrect value Course.name");
        } else LOG.warn("Null value Course.name");
    }

    /**
     * Returns a date representing {@link Course#startDate} of {@code Course} in db
     * The value returned will be have format yyyy-MM-dd
     *
     * @return start date of this course
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets a date representing {@link Course#startDate} of {@code Course} in db
     * The value should have format yyyy-MM-dd
     *
     * @param startDate start date of {@code Course}
     */
    public void setStartDate(Date startDate) {
        if (startDate != null)
            this.startDate = startDate;
        else LOG.warn("Null value Course.startDate");
    }

    /**
     * Returns a number representing {@link Course#duration} of {@code Course} in db
     * The value returned will be greater than 0
     * The value means quantity of month of course duration
     *
     * @return duration of this course
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets a number representing {@link Course#duration} of {@code Course} in db
     * The value should be greater than 0
     * The value means quantity of month of course duration
     *
     * @param duration duration of {@code Course}
     */
    public void setDuration(int duration) {
        if (duration > 0)
            this.duration = duration;
        else LOG.warn("Incorrect value Course.duration");
    }

    /**
     * Returns a number representing {@link Course#teacherId} of {@code Course} in db
     * The value returned will be greater than 0
     *
     * @return id of teacher of this course
     */
    public int getTeacherId() {
        return teacherId;
    }

    /**
     * Sets a number representing {@link Course#teacherId} of {@code Course} in db
     * The value should be greater than 0
     *
     * @param teacherId id of teacher of {@code Course} - foreign key in db
     */
    public void setTeacherId(int teacherId) {
        if (teacherId > 0)
            this.teacherId = teacherId;
        else LOG.warn("Incorrect value Course.teacherId");
    }

    /**
     * Returns a number representing {@link Course#themeId} of {@code Course} in db
     * The value returned will be greater than 0
     *
     * @return id of theme of this course
     */
    public int getThemeId() {
        return themeId;
    }

    /**
     * Sets a number representing {@link Course#themeId} of {@code Course} in db
     * The value should be greater than 0
     *
     * @param themeId id of theme of {@code Course} - foreign key in db
     */
    public void setThemeId(int themeId) {
        if (themeId > 0)
            this.themeId = themeId;
        else LOG.warn("Incorrect value Course.themeId");
    }

    /**
     * Initializes a {@code Course} object according to data that was taken from db
     *
     * @param resultSet data from db
     * @return new {@code Course} object
     */
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

    /**
     * Converts this {@code Course} object to a {@code String} object
     *
     * @return {@code String} object equals to {@code Course} object by values
     */
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
