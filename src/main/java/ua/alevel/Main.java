package ua.alevel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ua.alevel.dto.Course;
import ua.alevel.dto.Teacher;
import ua.alevel.services.CourseService;
import ua.alevel.services.GradeService;
import ua.alevel.services.TeacherService;

import java.util.Date;

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

        /*   разобраться почему некорректно показывает   */

        CourseService courseService = beanFactory.getBean(CourseService.class);

        System.out.println();
        System.out.println(courseService.selectNotStartedCoursesByStudent(1));
        System.out.println();
        System.out.println(courseService.selectStartedCoursesByStudent(1));
        System.out.println();
        System.out.println(courseService.selectEndedCoursesByStudent(1));

//        courseService.selectNotStartedCoursesByStudent(3);

    }
}
