package ua.alevel.dto;

/**
 * Class corresponding to db table teacher
 *
 * @autor Victoria Aliaeva
 * @version 1.0
 * @since 2020-11-01
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Teacher implements Table {

    /**
     * Field of logging events or errors
     */
    private static final Logger LOG = LoggerFactory.getLogger(Teacher.class);

    /**
     * Field of {@code Teacher} id
     */
    private int id;

    /**
     * Field of {@code Teacher} first name
     */
    private String firstName;

    /**
     * Field of {@code Teacher} last name
     */
    private String lastName;

    /**
     * Field of {@code Teacher} user id
     */
    private int userId;

    /**
     * Initializes a newly created empty {@code Teacher} object
     *
     * @see Teacher#Teacher(String, String)
     */
    public Teacher() {
    }

    /**
     * Initializes a newly created empty {@code Teacher} object
     *
     * @param firstName first name of {@code Teacher}
     * @param lastName  last name of {@code Teacher}
     * @see Teacher#Teacher()
     */
    public Teacher(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    /**
     * Returns a number representing {@link Teacher#userId} of {@code Teacher} in db
     * The value returned will be greater than 0
     *
     * @return id of user of this teacher
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets a number representing {@link Teacher#userId} of {@code Teacher} in db
     * The value should be greater than 0
     *
     * @param userId id of user of this teacher - foreign key in db
     */
    public void setUserId(int userId) {
        if (userId > 0)
            this.userId = userId;
        else LOG.warn("Incorrect value Teacher.userId");
    }

    /**
     * Returns a number representing {@link Teacher#id} of {@code Teacher} in db
     * The value returned will be greater than 0
     *
     * @return id of this teacher
     */
    public int getId() {
        return id;
    }

    /**
     * Sets a number representing {@link Teacher#id} of {@code Teacher} in db
     * The value should be greater than 0
     *
     * @param id id of {@code Teacher} - primary key in db, generated automatically
     */
    public void setId(int id) {
        if (id > 0)
            this.id = id;
        else LOG.warn("Incorrect value Teacher.id");
    }

    /**
     * Returns a string representing {@link Teacher#firstName} of {@code Teacher} in db
     *
     * @return first name of this teacher
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets a string representing {@link Teacher#firstName} of {@code Teacher} in db
     *
     * @param firstName first name of {@code Teacher}
     */
    public void setFirstName(String firstName) {
        if (firstName != null) {
            if (!firstName.isEmpty())
                this.firstName = firstName;
            else LOG.warn("Incorrect value Teacher.firstName");
        } else LOG.warn("Null value Teacher.firstName");
    }

    /**
     * Returns a string representing {@link Teacher#lastName} of {@code Teacher} in db
     *
     * @return last name of this teacher
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets a string representing {@link Teacher#lastName} of {@code Teacher} in db
     *
     * @param lastName first name of {@code Teacher}
     */
    public void setLastName(String lastName) {
        if (lastName != null) {
            if (!lastName.isEmpty())
                this.lastName = lastName;
            else LOG.warn("Incorrect value Teacher.lastName");
        } else LOG.warn("Null value Teacher.lastName");
    }

    /**
     * Initializes a {@code Teacher} object according to data that was taken from db
     *
     * @param resultSet data from db
     * @return new {@code Teacher} object
     */
    @Override
    public Teacher mapResultSetToTableObject(ResultSet resultSet) {
        Teacher current = new Teacher();

        try {
            current.setId(resultSet.getInt("id"));
            current.setFirstName(resultSet.getString("firstName"));
            current.setLastName(resultSet.getString("lastName"));
            current.setUserId(resultSet.getInt("userId"));
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }

        return current;
    }

    /**
     * Converts this {@code Teacher} object to a {@code String} object
     *
     * @return {@code String} object equals to {@code Teacher} object by values
     */
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
