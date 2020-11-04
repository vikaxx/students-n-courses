package ua.alevel.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User implements Table {
    private static final Logger LOG = LoggerFactory.getLogger(User.class);

    private int id;
    private String login;
    private String pass;
    private int teacherId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    private int studentId;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        if (teacherId > 0)
            this.teacherId = teacherId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type != null) {
            if (!type.isEmpty())
                this.type = type;
            else LOG.warn("Incorrect value User.type");
        } else LOG.warn("Null value User.type");
    }

    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0)
            this.id = id;
        else LOG.warn("Incorrect value User.id");
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login != null) {
            if (!login.isEmpty())
                this.login = login;
            else LOG.warn("Incorrect value User.login");
        } else LOG.warn("Null value User.login");
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        if (pass != null) {
            if (!pass.isEmpty())
                this.pass = pass;
            else LOG.warn("Incorrect value User.pass");
        } else LOG.warn("Null value User.pass");
    }

    public User(String login, String pass, String type) {
        this.setLogin(login);
        this.setPass(pass);
        this.setType(type);
    }

    public User() {
    }

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
