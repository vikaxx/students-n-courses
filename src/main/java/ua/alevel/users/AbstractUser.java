package ua.alevel.users;

import ua.alevel.dto.Course;
import ua.alevel.dto.additional.CourseWithStudentsAmount;

import java.util.List;

public interface AbstractUser {

    List<Course> selectAllCourses();

    List<Course> selectAllCoursesAZ();

    List<Course> selectAllCoursesZA();

    List<Course> selectCoursesSortedByDuration(String orderByDirection);

    List<CourseWithStudentsAmount> selectCoursesSortedByStudentsQuantity(String orderByDirection);

    List<Course> selectCoursesByTheme(String theme);

    List<Course> selectCoursesByTeacher(int teacherId);
}
