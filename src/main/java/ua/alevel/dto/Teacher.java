package ua.alevel.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Teacher implements Table {
    private static final Logger LOG = LoggerFactory.getLogger(Teacher.class);

    private int id;
    private String firstName;
    private String lastName;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        if (userId > 0)
            this.userId = userId;
        else LOG.warn("Incorrect value Teacher.userId");
    }

    public Teacher() {
    }

    public Teacher(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0)
            this.id = id;
        else LOG.warn("Incorrect value Teacher.id");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName != null) {
            if (!firstName.isEmpty())
                this.firstName = firstName;
            else LOG.warn("Incorrect value Teacher.firstName");
        } else LOG.warn("Null value Teacher.firstName");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName != null) {
            if (!lastName.isEmpty())
                this.lastName = lastName;
            else LOG.warn("Incorrect value Teacher.lastName");
        } else LOG.warn("Null value Teacher.lastName");
    }

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
