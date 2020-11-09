package ua.alevel.dto;

/**
 * Class corresponding to db table `user`
 *
 * @autor Victoria Aliaeva
 * @version 1.0
 * @since 2020-11-01
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User implements Table {

    /**
     * Field of logging events or errors
     */
    private static final Logger LOG = LoggerFactory.getLogger(User.class);

    /**
     * Field of {@code User} id
     */
    private int id;

    /**
     * Field of {@code User} login
     */
    private String login;

    /**
     * Field of {@code User} password
     */
    private String pass;

    /**
     * Field of {@code User} teacher id
     */
    private int teacherId;

    /**
     * Field of {@code User} student id
     */
    private int studentId;

    /**
     * Field of {@code User} type
     */
    private String type;

    /**
     * Initializes a newly created empty {@code User} object
     *
     * @see User#User(String, String, String)
     */
    public User() {
    }

    /**
     * Initializes a newly created {@code User} object
     *
     * @param login login of {@code User}
     * @param pass  password of {@code User}
     * @param type  type of {@code User}
     * @see User#User()
     */
    public User(String login, String pass, String type) {
        this.setLogin(login);
        this.setPass(pass);
        this.setType(type);
    }

    /**
     * Returns a number representing {@link User#studentId} of {@code User} in db
     * The value returned will be greater than 0
     *
     * @return id of student
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Sets a number representing {@link User#studentId} of {@code User} in db
     * The value should be greater than 0
     *
     * @param studentId id of student
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * Returns a number representing {@link User#teacherId} of {@code User} in db
     * The value returned will be greater than 0
     *
     * @return id of teacher
     */
    public int getTeacherId() {
        return teacherId;
    }

    /**
     * Sets a number representing {@link User#teacherId} of {@code User} in db
     * The value should be greater than 0
     *
     * @param teacherId id of teacher
     */
    public void setTeacherId(int teacherId) {
        if (teacherId > 0)
            this.teacherId = teacherId;
    }

    /**
     * Returns a string representing {@link User#type} of {@code User} in db
     *
     * @return type of user - "teacher" or "student"
     */
    public String getType() {
        return type;
    }

    /**
     * Sets a string representing {@link User#type} of {@code User} in db
     *
     * @param type type of {@code User}
     */
    public void setType(String type) {
        if (type != null) {
            if (!type.isEmpty())
                this.type = type;
            else LOG.warn("Incorrect value User.type");
        } else LOG.warn("Null value User.type");
    }

    /**
     * Returns a number representing {@link User#id} of {@code User} in db
     * The value returned will be greater than 0
     *
     * @return id of this user
     */
    public int getId() {
        return id;
    }

    /**
     * Sets a number representing {@link User#id} of {@code User} in db
     * The value should be greater than 0
     *
     * @param id id of {@code User} - primary key in db, generated automatically
     */
    public void setId(int id) {
        if (id > 0)
            this.id = id;
        else LOG.warn("Incorrect value User.id");
    }

    /**
     * Returns a string representing {@link User#login} of {@code User} in db
     *
     * @return login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets a string representing {@link User#login} of {@code User} in db
     *
     * @param login login of {@code User}
     */
    public void setLogin(String login) {
        if (login != null) {
            if (!login.isEmpty())
                this.login = login;
            else LOG.warn("Incorrect value User.login");
        } else LOG.warn("Null value User.login");
    }

    /**
     * Returns a string representing {@link User#pass} of {@code User} in db
     *
     * @return password
     */
    public String getPass() {
        return pass;
    }

    /**
     * Sets a string representing {@link User#pass} of {@code User} in db
     *
     * @param pass password of {@code User}
     */
    public void setPass(String pass) {
        if (pass != null) {
            if (!pass.isEmpty())
                this.pass = pass;
            else LOG.warn("Incorrect value User.pass");
        } else LOG.warn("Null value User.pass");
    }

    /**
     * Initializes a {@code User} object according to data that was taken from db
     *
     * @param resultSet data from db
     * @return new {@code User} object
     */
    @Override
    public User mapResultSetToTableObject(ResultSet resultSet) {
        User current = new User();

        try {
            current.setId(resultSet.getInt("id"));
            current.setLogin(resultSet.getString("login"));
            current.setPass(resultSet.getString("pass"));
            current.setType(resultSet.getString("type"));
            current.setTeacherId(resultSet.getInt("teacherId"));
            current.setStudentId(resultSet.getInt("studentId"));
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }
        return current;
    }

    /**
     * Converts this {@code User} object to a {@code String} object
     *
     * @return {@code String} object equals to {@code User} object by values
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", teacherId=" + teacherId +
                ", studentId=" + studentId +
                ", type='" + type + '\'' +
                '}';
    }
}
