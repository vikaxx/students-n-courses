package ua.alevel.users.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.alevel.dto.Course;
import ua.alevel.dto.additional.CourseWithStudentsAmount;
import ua.alevel.services.CourseService;
import ua.alevel.users.AbstractUser;

import java.util.List;

@Service
public class AbstractUserImpl implements AbstractUser {
    @Autowired
    private CourseService courseService;

    public List<Course> selectAllCourses() {
        return courseService.selectAllCourses();
    }

    public List<Course> selectAllCoursesAZ() {
        return courseService.selectAllCoursesAZ();
    }

    public List<Course> selectAllCoursesZA() {
        return courseService.selectAllCoursesZA();
    }

    public List<Course> selectCoursesSortedByDuration(String orderByDirection) {
        if (orderByDirection != null) {
            orderByDirection = orderByDirection.toUpperCase();
            if (orderByDirection.equals("ASC") || orderByDirection.equals("DESC"))
                return courseService.selectCoursesSortedByDuration(orderByDirection);
        }
        return null;
    }

    public List<CourseWithStudentsAmount> selectCoursesSortedByStudentsQuantity(String orderByDirection) {
        if (orderByDirection != null) {
            orderByDirection = orderByDirection.toUpperCase();
            if (orderByDirection.equals("ASC") || orderByDirection.equals("DESC"))
                return courseService.selectCoursesSortedByStudentsQuantity(orderByDirection);
        }
        return null;
    }

    public List<Course> selectCoursesByTheme(String theme) {
        if (theme != null)
            if (!theme.isEmpty())
                return courseService.selectCoursesByTheme(theme);
        return null;
    }

    public List<Course> selectCoursesByTeacher(int teacherId) {
        if (teacherId > 0)
            return courseService.selectCoursesByTeacher(teacherId);
        else return null;
    }
}
