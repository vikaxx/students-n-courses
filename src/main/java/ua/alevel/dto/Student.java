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

    public Student(String firstName, String lastName, boolean isBanned) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setBanned(isBanned);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0)
            this.id = id;
        else LOG.warn("Incorrect value Student.id");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName != null) {
            if (!firstName.isEmpty())
                this.firstName = firstName;
            else LOG.warn("Incorrect value Student.firstName");
        } else LOG.warn("Null value Student.firstName");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName != null) {
            if (!lastName.isEmpty())
                this.lastName = lastName;
            else LOG.warn("Incorrect value Student.lastName");
        } else LOG.warn("Null value Student.lastName");
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
