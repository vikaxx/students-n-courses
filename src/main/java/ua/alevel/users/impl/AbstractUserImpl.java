package ua.alevel.users.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.alevel.dto.Course;
import ua.alevel.dto.additional.CourseWithStudentsAmount;
import ua.alevel.services.CourseService;
import ua.alevel.users.AbstractUser;

import java.util.List;

public class AbstractUserImpl implements AbstractUser{
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
        return courseService.selectCoursesSortedByDuration(orderByDirection);
    }

    public List<CourseWithStudentsAmount> selectCoursesSortedByStudentsQuantity(String orderByDirection) {
        return courseService.selectCoursesSortedByStudentsQuantity(orderByDirection);
    }

    public List<Course> selectCoursesByTheme(String theme) {
        return courseService.selectCoursesByTheme(theme);
    }

    public List<Course> selectCoursesByTeacher(int teacherId) {
        return courseService.selectCoursesByTeacher(teacherId);
    }
}
