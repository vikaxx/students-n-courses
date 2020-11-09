package ua.alevel.dto;

/**
 * Class corresponding to db table grade
 *
 * @autor Victoria Aliaeva
 * @version 1.0
 * @since 2020-11-01
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Grade implements Table {

    /**
     * Field of logging events or errors
     */
    private static final Logger LOG = LoggerFactory.getLogger(Grade.class);

    /**
     * Field of {@code Grade} id
     */
    private int id;

    /**
     * Field of {@code Grade} mark
     * Should be from 0 to 100
     */
    private int mark;

    /**
     * Field of {@code Grade} student course id
     */
    private int studentsCourseId;

    /**
     * Initializes a newly created empty {@code Grade} object
     *
     * @see Grade#Grade(int, int)
     * @see Grade#Grade(int, int, int)
     */
    public Grade() {
    }

    /**
     * Initializes a newly created {@code Grade} object
     *
     * @param mark             mark of student course
     * @param studentsCourseId id of student course - foreign key in db
     * @see Grade#Grade()
     * @see Grade#Grade(int, int, int)
     */
    public Grade(int mark, int studentsCourseId) {
        this.setMark(mark);
        this.setStudentsCourseId(studentsCourseId);
    }

    /**
     * Initializes a newly created {@code Grade} object
     *
     * @param id               id of {@code Grade} - primary key in db, generated automatically
     * @param mark             mark of student course
     * @param studentsCourseId id of student course - foreign key in db
     * @see Grade#Grade()
     * @see Grade#Grade(int, int)
     */
    public Grade(int id, int mark, int studentsCourseId) {
        this.setId(id);
        this.setMark(mark);
        this.setStudentsCourseId(studentsCourseId);
    }

    /**
     * Returns a number representing {@link Grade#id} of {@code Grade} in db
     * The value returned will be greater than 0
     *
     * @return id of this grade
     */
    public int getId() {
        return id;
    }

    /**
     * Sets a number representing {@link Grade#id} of {@code Grade} in db
     * The value should be greater than 0
     *
     * @param id id of {@code Grade} - primary key in db, generated automatically
     */
    public void setId(int id) {
        if (id > 0)
            this.id = id;
        else LOG.warn("Incorrect value Grade.id");
    }

    /**
     * Returns a number representing {@link Grade#mark} of {@code Grade} in db
     * The value returned will be from 0 to 100
     *
     * @return mark of student course
     */
    public int getMark() {
        return mark;
    }

    /**
     * Sets a number representing {@link Grade#mark} of {@code Grade} in db
     * The value returned will be from 0 to 100
     *
     * @param mark mark of student course
     */
    public void setMark(int mark) {
        if (mark > -1 && mark < 101)
            this.mark = mark;
        else LOG.warn("Incorrect value Grade.mark");
    }

    /**
     * Returns a number representing {@link Grade#studentsCourseId} of {@code Grade} in db
     * The value will be greater than 0
     *
     * @return id of student course
     */
    public int getStudentsCourseId() {
        return studentsCourseId;
    }

    /**
     * Sets a number representing {@link Grade#studentsCourseId} of {@code Grade} in db
     * The value should be greater than 0
     *
     * @param studentsCourseId id of student course - foreign key in db
     */
    public void setStudentsCourseId(int studentsCourseId) {
        if (studentsCourseId > 0)
            this.studentsCourseId = studentsCourseId;
        else LOG.warn("Incorrect value Grade.studentsCourseId");
    }

    /**
     * Converts this {@code Grade} object to a {@code String} object
     *
     * @return {@code String} object equals to {@code Grade} object by values
     */
    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", mark=" + mark +
                ", studentsCourseId=" + studentsCourseId +
                '}';
    }

    /**
     * Initializes a {@code Grade} object according to data that was taken from db
     *
     * @param resultSet data from db
     * @return new {@code Grade} object
     */
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
