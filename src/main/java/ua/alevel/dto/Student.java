package ua.alevel.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student implements Table {
    private static final Logger LOG = LoggerFactory.getLogger(Student.class);

    private int id;
    private String firstName;
    private String lastName;
    private boolean isBanned;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, boolean isBanned) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isBanned = isBanned;
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

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    @Override
    public Student mapResultSetToTableObject(ResultSet resultSet) {
        Student current = new Student();

        try {
            current.setId(resultSet.getInt("id"));
            current.setFirstName(resultSet.getString("firstName"));
            current.setLastName(resultSet.getString("lastName"));
            current.setBanned(resultSet.getBoolean("isBanned"));
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }

        return current;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isBanned=" + isBanned +
                '}';
    }
}
