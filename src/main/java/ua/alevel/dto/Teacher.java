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

    public Teacher() {
    }

    public Teacher(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Teacher mapResultSetToTableObject(ResultSet resultSet) {
        Teacher current = new Teacher();

        try {
            current.setId(resultSet.getInt("id"));
            current.setFirstName(resultSet.getString("firstName"));
            current.setLastName(resultSet.getString("lastName"));
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
                '}';
    }
}
