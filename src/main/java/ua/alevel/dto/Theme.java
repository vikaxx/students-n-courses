package ua.alevel.dto;

/**
 * Class corresponding to db table theme
 *
 * @autor Victoria Aliaeva
 * @version 1.0
 * @since 2020-11-01
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Theme implements Table {

    /**
     * Field of logging events or errors
     */
    private static final Logger LOG = LoggerFactory.getLogger(Theme.class);

    /**
     * Field of {@code Theme} id
     */
    private int id;

    /**
     * Field of {@code Theme} name
     */
    private String name;

    /**
     * Initializes a newly created empty {@code Theme} object
     *
     * @see Theme#Theme(String)
     */
    public Theme() {
    }

    /**
     * Initializes a newly created {@code Theme} object
     *
     * @param name name of {@code Theme}
     * @see Theme#Theme()
     */
    public Theme(String name) {
        this.setName(name);
    }

    /**
     * Returns a number representing {@link Theme#id} of {@code Theme} in db
     * The value returned will be greater than 0
     *
     * @return id of this theme
     */
    public int getId() {
        return id;
    }

    /**
     * Sets a number representing {@link Theme#id} of {@code Theme} in db
     * The value should be greater than 0
     *
     * @param id id of {@code Theme} - primary key in db, generated automatically
     */
    public void setId(int id) {
        if (id > 0)
            this.id = id;
        else LOG.warn("Incorrect value Theme.id");
    }

    /**
     * Returns a string representing {@link Theme#name} of {@code Theme} in db
     *
     * @return name of this theme
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a string representing {@link Theme#name} of {@code Theme} in db
     *
     * @param name name of {@code Theme}
     */
    public void setName(String name) {
        if (name != null) {
            if (!name.isEmpty())
                this.name = name;
            else LOG.warn("Incorrect value Theme.name");
        } else LOG.warn("Null value Theme.name");
    }

    /**
     * Initializes a {@code Theme} object according to data that was taken from db
     *
     * @param resultSet data from db
     * @return new {@code Theme} object
     */
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

    /**
     * Converts this {@code Theme} object to a {@code String} object
     *
     * @return {@code String} object equals to {@code Theme} object by values
     */
    @Override
    public String toString() {
        return "Theme{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
