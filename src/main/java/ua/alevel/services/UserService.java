package ua.alevel.services;

import ua.alevel.dto.User;

public interface UserService {
    User selectUserByLogin(String login);
}
