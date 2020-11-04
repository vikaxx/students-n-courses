package ua.alevel.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.alevel.dao.UserDao;
import ua.alevel.dto.User;
import ua.alevel.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserByLogin(String login) {
        if (login != null)
            if (!login.isEmpty())
                return userDao.selectUserByLogin(login);
        return null;
    }
}
