package ua.alevel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ua.alevel.dao.AdminDao;
import ua.alevel.dto.*;
import ua.alevel.services.AdminService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Main {
    public static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        final ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        AdminService adminService = beanFactory.getBean(AdminService.class);

//        List<Table> courses = adminService.<Teacher>selectAllRecordsInTable("Teacher");
//        courses.forEach(System.out::println);

//        Date date = new Date();
//        try {
//            date = new SimpleDateFormat("yyyy-MM-dd").parse("2022-3-4");
//        } catch (ParseException e) {
//            LOG.error("data exception", e);
//        }
//        Course course = new Course(6,"C++ 23", date, 3, 4, 2);
        System.out.println(adminService.setStudentBanned(5, false));
        System.out.println(adminService.setStudentBanned(6, false));


    }
}
