package ua.alevel.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class MenuImpl implements Menu {
    private final Logger LOG = LoggerFactory.getLogger(MenuImpl.class);
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private UserAuth userAuth;

    @Autowired
    public MenuImpl(UserAuth userAuth) {
        this.userAuth = userAuth;
    }

    public MenuImpl() {
    }

    public void mainMenu() {
        List<Object> user = userAuth.getUserIdWithType();
        String userType = (String) user.get(0);
        int userId = (int) user.get(1);

        switch (userType) {
            case "admin":
                mainMenuAdmin();
                break;
            case "teacher":
                mainMenuTeacher(userId);
                break;
            case "student":
                mainMenuStudent(userId);
                break;
        }
    }

    private void mainMenuAdmin() {

    }

    private void mainMenuStudent(int id) {
        System.out.println(id);
    }

    private void mainMenuTeacher(int id) {
        System.out.println(id);
    }

}

