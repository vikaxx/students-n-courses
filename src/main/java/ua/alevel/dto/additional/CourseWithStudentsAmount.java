package ua.alevel.dto.additional;

/**
 * Class that shows students amount for courses
 * This class is used to create objects of merged tables
 *
 * @autor Victoria Aliaeva
 * @version 1.0
 * @since 2020-11-01
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.alevel.dao.impl.TableDaoImpl;
import ua.alevel.dto.Table;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class CourseWithStudentsAmount implements Table {

    /**
     * Field of logging events or errors
     */
    private static final Logger LOG = LoggerFactory.getLogger(CourseWithStudentsAmount.class);

    /**
     * Field of {@code Course} id
     */
    private int id;

    /**
     * Field of {@code CourseWithStudentsAmount} name
     */
    private String name;

    /**
     * Field of {@code CourseWithStudentsAmount} start date
     */
    private Date startDate;

    /**
     * Field of {@code CourseWithStudentsAmount} duration
     */
    private int duration;

    /**
     * Field of {@code CourseWithStudentsAmount} teacher id
     */
    private int teacherId;

    /**
     * Field of {@code CourseWithStudentsAmount} theme id
     */
    private int themeId;

    /**
     * Field of {@code CourseWithStudentsAmount} students amount
     */
    private int studentsAmount;

    /**
     * Initializes a newly created empty {@code CourseWithStudentsAmount} object
     *
     * @see CourseWithStudentsAmount#CourseWithStudentsAmount(int, String, Date, int, int, int, int)
     */
    public CourseWithStudentsAmount() {
    }

    /**
     * Initializes a newly created {@code CourseWithStudentsAmount} object
     *
     * @param id             id of {@code CourseWithStudentsAmount}
     * @param name           name of {@code CourseWithStudentsAmount}
     * @param startDate      start date of {@code CourseWithStudentsAmount}
     * @param duration       duration of {@code CourseWithStudentsAmount} in months
     * @param teacherId      id of teacher of {@code CourseWithStudentsAmount}
     * @param themeId        id of theme of {@code CourseWithStudentsAmount}
     * @param studentsAmount amount of students of {@code CourseWithStudentsAmount}
     * @see CourseWithStudentsAmount#CourseWithStudentsAmount()
     */
    public CourseWithStudentsAmount(int id, String name, Date startDate, int duration, int teacherId, int themeId, int studentsAmount) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.duration = duration;
        this.teacherId = teacherId;
        this.themeId = themeId;
        this.studentsAmount = studentsAmount;
    }

    /**
     * Returns a number representing {@link CourseWithStudentsAmount#id} of {@code Course} in db
     * The value returned will be greater than 0
     *
     * @return id of course
     */
    public int getId() {
        return id;
    }

    /**
     * Sets a number representing {@link CourseWithStudentsAmount#id} of {@code Course} in db
     * The value should be greater than 0
     *
     * @param id id of {@code Course} - primary key in db, generated automatically
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns a string representing {@link CourseWithStudentsAmount#name} of {@code Course} in db
     *
     * @return name of course
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a string representing {@link CourseWithStudentsAmount#name} of {@code Course} in db
     *
     * @param name name of {@code CourseWithStudentsAmount}
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a date representing {@link CourseWithStudentsAmount#startDate} of {@code Course} in db
     * The value returned will be have format yyyy-MM-dd
     *
     * @return start date of this course
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets a date representing {@link CourseWithStudentsAmount#startDate} of {@code Course} in db
     * The value should have format yyyy-MM-dd
     *
     * @param startDate start date of {@code Course}
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Returns a number representing {@link CourseWithStudentsAmount#duration} of {@code Course} in db
     * The value returned will be greater than 0
     * The value means quantity of month of course duration
     *
     * @return duration of course
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets a number representing {@link CourseWithStudentsAmount#duration} of {@code Course} in db
     * The value should be greater than 0
     * The value means quantity of month of course duration
     *
     * @param duration duration of {@code CourseWithStudentsAmount}
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Returns a number representing {@link CourseWithStudentsAmount#teacherId} of {@code Course} in db
     * The value returned will be greater than 0
     *
     * @return id of teacher of course
     */
    public int getTeacherId() {
        return teacherId;
    }

    /**
     * Sets a number representing {@link CourseWithStudentsAmount#teacherId} of {@code Course} in db
     * The value should be greater than 0
     *
     * @param teacherId id of teacher of {@code CourseWithStudentsAmount}
     */
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * Returns a number representing {@link CourseWithStudentsAmount#themeId} of {@code Course} in db
     * The value returned will be greater than 0
     *
     * @return id of theme of course
     */
    public int getThemeId() {
        return themeId;
    }

    /**
     * Sets a number representing {@link CourseWithStudentsAmount#themeId} of {@code Course} in db
     * The value should be greater than 0
     *
     * @param themeId id of theme of {@code CourseWithStudentsAmount}
     */
    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    /**
     * Returns a number representing {@link CourseWithStudentsAmount#studentsAmount}
     * The value returned will be greater than 0
     *
     * @return amount of students of course
     */
    public int getStudentsAmount() {
        return studentsAmount;
    }

    /**
     * Sets a number representing {@link CourseWithStudentsAmount#studentsAmount}
     * The value should be greater than 0
     *
     * @param studentsAmount amount of students of {@code CourseWithStudentsAmount}
     */
    public void setStudentsAmount(int studentsAmount) {
        this.studentsAmount = studentsAmount;
    }

    /**
     * Converts this {@code CourseWithStudentsAmount} object to a {@code String} object
     *
     * @return {@code String} object equals to {@code CourseWithStudentsAmount} object by values
     */
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

    /**
     * Initializes a {@code CourseWithStudentsAmount} object according to data that was taken from db
     *
     * @param resultSet data from db
     * @return new {@code CourseWithStudentsAmount} object
     */
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
