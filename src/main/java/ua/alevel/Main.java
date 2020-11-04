package ua.alevel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ua.alevel.util.Menu;
import ua.alevel.util.MenuImpl;

@SpringBootApplication
public class Main {
    public static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        final ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

//        TeacherService teacherService = beanFactory.getBean(TeacherService.class);
//
//        Teacher teacher = new Teacher("Max", "Max");
//
//        System.out.println(teacher);
//
//        System.out.println(teacherService.addNewTeacher(teacher));

        Menu menu = beanFactory.getBean(Menu.class);

        menu.mainMenu();


    }
}
