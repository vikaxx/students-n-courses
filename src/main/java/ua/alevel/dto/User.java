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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0)
            this.id = id;
        else LOG.warn("Incorrect value Student.id");
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

    public User(String login, String pass) {
        this.setLogin(login);
        this.setPass(pass);
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

    @Override
    public User mapResultSetToTableObject(ResultSet resultSet) {
        User current = new User();

        try {
            current.setId(resultSet.getInt("id"));
            current.setLogin(resultSet.getString("login"));
            current.setPass(resultSet.getString("pass"));
        } catch (SQLException e) {
            LOG.error("SQL error: ", e);
        }

        return current;
    }
}
