package ua.alevel.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Theme implements Table {
    private static final Logger LOG = LoggerFactory.getLogger(Theme.class);

    private int id;
    private String name;

    public Theme() {
    }

    public Theme(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Theme mapResultSetToTableObject(ResultSet resultSet) {
        Theme current = new Theme();

        try {
            current.setId(resultSet.getInt("id"));
            current.setName(resultSet.getString("name"));
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }

        return current;
    }

    @Override
    public String toString() {
        return "Theme{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}