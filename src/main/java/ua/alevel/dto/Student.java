package ua.alevel.dto;

/**
 * Class corresponding to db table student
 *
 * @autor Victoria Aliaeva
 * @version 1.0
 * @since 2020-11-01
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student implements Table {

    /**
     * Field of logging events or errors
     */
    private static final Logger LOG = LoggerFactory.getLogger(Student.class);

    /**
     * Field of {@code Student} id
     */
    private int id;

    /**
     * Field of {@code Student} first name
     */
    private String firstName;

    /**
     * Field of {@code Student} last name
     */
    private String lastName;

    /**
     * Field of info is {@code Student} banned
     */
    private boolean isBanned;

    /**
     * Field of {@code Student} user id
     */
    private int userId;

    /**
     * Initializes a newly created empty {@code Student} object
     *
     * @see Student#Student(String, String, boolean)
     */
    public Student() {
    }

    /**
     * Initializes a newly created {@code Student} object
     *
     * @param firstName first name of {@code Student}
     * @param lastName  last name of {@code Student}
     * @param isBanned  info is {@code Student} banned
     * @see Student#Student()
     */
    public Student(String firstName, String lastName, boolean isBanned) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setBanned(isBanned);
    }

    /**
     * Returns a number representing {@link Student#userId} of {@code Student} in db
     * The value returned will be greater than 0
     *
     * @return id of user of this student
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets a number representing {@link Student#userId} of {@code Student} in db
     * The value should be greater than 0
     *
     * @param userId id of user of this student - foreign key in db
     */
    public void setUserId(int userId) {
        if (userId > 0)
            this.userId = userId;
        else LOG.warn("Incorrect value User.userId");
    }

    /**
     * Returns a number representing {@link Student#id} of {@code Student} in db
     * The value returned will be greater than 0
     *
     * @return id of this student
     */
    public int getId() {
        return id;
    }

    /**
     * Sets a number representing {@link Student#id} of {@code Student} in db
     * The value should be greater than 0
     *
     * @param id id of {@code Student} - primary key in db, generated automatically
     */
    public void setId(int id) {
        if (id > 0)
            this.id = id;
        else LOG.warn("Incorrect value Student.id");
    }

    /**
     * Returns a string representing {@link Student#firstName} of {@code Student} in db
     *
     * @return first name of this student
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets a string representing {@link Student#firstName} of {@code Student} in db
     *
     * @param firstName first name of {@code Student}
     */
    public void setFirstName(String firstName) {
        if (firstName != null) {
            if (!firstName.isEmpty())
                this.firstName = firstName;
            else LOG.warn("Incorrect value Student.firstName");
        } else LOG.warn("Null value Student.firstName");
    }

    /**
     * Returns a string representing {@link Student#lastName} of {@code Student} in db
     *
     * @return last name of this student
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets a string representing {@link Student#lastName} of {@code Student} in db
     *
     * @param lastName first name of {@code Student}
     */
    public void setLastName(String lastName) {
        if (lastName != null) {
            if (!lastName.isEmpty())
                this.lastName = lastName;
            else LOG.warn("Incorrect value Student.lastName");
        } else LOG.warn("Null value Student.lastName");
    }

    /**
     * Returns a boolean representing {@link Student#isBanned} of {@code Student} in db
     * Returned value "true" means that student is banned
     * Returned value "false" means that student is not banned
     *
     * @return true or false
     */
    public boolean isBanned() {
        return isBanned;
    }

    /**
     * Sets a boolean representing {@link Student#isBanned} of {@code Student} in db
     * Value "true" means that student is banned
     * Value "false" means that student is not banned
     *
     * @param banned info is {@code Student} banned
     */
    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    /**
     * Initializes a {@code Student} object according to data that was taken from db
     *
     * @param resultSet data from db
     * @return new {@code Student} object
     */
    @Override
    public Student mapResultSetToTableObject(ResultSet resultSet) {
        Student current = new Student();

        try {
            current.setId(resultSet.getInt("id"));
            current.setFirstName(resultSet.getString("firstName"));
            current.setLastName(resultSet.getString("lastName"));
            current.setBanned(resultSet.getBoolean("isBanned"));
            current.setUserId(resultSet.getInt("userId"));
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }

        return current;
    }

    /**
     * Converts this {@code Student} object to a {@code String} object
     *
     * @return {@code String} object equals to {@code Student} object by values
     */
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isBanned=" + isBanned +
                ", userId=" + userId +
                '}';
    }
}
