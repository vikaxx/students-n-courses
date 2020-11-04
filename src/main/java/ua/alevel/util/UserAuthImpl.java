package ua.alevel.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.alevel.dto.User;
import ua.alevel.services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserAuthImpl implements UserAuth {
    private final Logger LOG = LoggerFactory.getLogger(UserAuthImpl.class);
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Autowired
    private UserService userService;

    @Override
    public List<Object> getUserIdWithType() {
        System.out.println("Welcome to course system!");

        User user = auth();
        List<Object> userIdWithType = new ArrayList<>();

        userIdWithType.add(user.getType());

        switch (user.getType()) {
            case "teacher":
                userIdWithType.add(user.getTeacherId());
                break;
            case "student":
                userIdWithType.add(user.getStudentId());
                break;
            default:
                userIdWithType.add(0);
                break;
        }

        return userIdWithType;
    }

    private User check(String login, String pass) {
        User user = userService.selectUserByLogin(login);
        if (user != null)
            if (user.getPass().equals(pass))
                return user;
        return null;
    }

    private User auth() {
        System.out.println("Input your login and password please.");
        System.out.print("Login: ");

        String login = "";
        String pass = "";

        try {
            login = reader.readLine();
        } catch (IOException e) {
            LOG.error("IO exception ", e);
        }

        System.out.print("Password: ");

        try {
            pass = reader.readLine();

        } catch (IOException e) {
            LOG.error("IO exception ", e);
        }
        User user = check(login, pass);
        if (user == null) {
            System.out.println("Incorrect user or password. Try again.");
            return auth();
        }
        return user;
    }

}
