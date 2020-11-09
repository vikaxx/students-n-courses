package ua.alevel.dto;

/**
 * Class corresponding to db table studentCourse
 * This table is used to avoid M : M relation within course and student
 *
 * @autor Victoria Aliaeva
 * @version 1.0
 * @since 2020-11-01
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentsCourse implements Table {

    /**
     * Field of logging events or errors
     */
    private static final Logger LOG = LoggerFactory.getLogger(StudentsCourse.class);

    /**
     * Field of {@code StudentsCourse} id
     */
    private int id;

    /**
     * Field of {@code StudentsCourse} student id
     */
    private int studentId;

    /**
     * Field of {@code StudentsCourse} course id
     */
    private int courseId;

    /**
     * Initializes a newly created empty {@code StudentsCourse} object
     *
     * @see StudentsCourse#StudentsCourse(int, int)
     */
    public StudentsCourse() {
    }

    /**
     * Initializes a newly created {@code StudentsCourse} object
     *
     * @param studentId id of student - foreign key in db
     * @param courseId  id of course - foreign key in db
     * @see StudentsCourse#StudentsCourse()
     */
    public StudentsCourse(int studentId, int courseId) {
        this.setStudentId(studentId);
        this.setCourseId(courseId);
    }

    /**
     * Returns a number representing {@link StudentsCourse#id} of {@code StudentsCourse} in db
     * The value returned will be greater than 0
     *
     * @return id of this record in table
     */
    public int getId() {
        return id;
    }

    /**
     * Sets a number representing {@link StudentsCourse#id} of {@code StudentsCourse} in db
     * The value should be greater than 0
     *
     * @param id id of {@code StudentsCourse} - primary key in db, generated automatically
     */
    public void setId(int id) {
        if (id > 0)
            this.id = id;
        else LOG.warn("Incorrect value StudentsCourse.id");
    }

    /**
     * Returns a number representing {@link StudentsCourse#studentId} of {@code StudentsCourse} in db
     * The value returned will be greater than 0
     *
     * @return id of student
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Sets a number representing {@link StudentsCourse#studentId} of {@code StudentsCourse} in db
     * The value should be greater than 0
     *
     * @param studentId id of student - foreign key in db
     */
    public void setStudentId(int studentId) {
        if (studentId > 0)
            this.studentId = studentId;
        else LOG.warn("Incorrect value StudentsCourse.studentId");
    }

    /**
     * Returns a number representing {@link StudentsCourse#courseId} of {@code StudentsCourse} in db
     * The value returned will be greater than 0
     *
     * @return id of course
     */
    public int getCourseId() {
        return courseId;
    }

    /**
     * Sets a number representing {@link StudentsCourse#courseId} of {@code StudentsCourse} in db
     * The value should be greater than 0
     *
     * @param courseId id of course - foreign key in db
     */
    public void setCourseId(int courseId) {
        if (courseId > 0)
            this.courseId = courseId;
        else LOG.warn("Incorrect value StudentsCourse.courseId");
    }

    /**
     * Initializes a {@code StudentsCourse} object according to data that was taken from db
     *
     * @param resultSet data from db
     *
     * @return new {@code StudentsCourse} object
     */
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

    /**
     * Converts this {@code StudentsCourse} object to a {@code String} object
     *
     * @return {@code String} object equals to {@code StudentsCourse} object by values
     */
    @Override
    public String toString() {
        return "StudentsCourse{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                '}';
    }
}
