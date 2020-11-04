package ua.alevel.dao;

import ua.alevel.dto.User;

public interface UserDao {
    User selectUserByLogin(String login);
}
