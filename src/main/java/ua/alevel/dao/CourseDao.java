package ua.alevel.dao;

import ua.alevel.dto.Course;

import java.util.List;

public interface CourseDao {
    List<Course> selectAllCoursesAZ();

    List<Course> selectAllCoursesZA();

    List<Course> selectCoursesByDuration(int duration);

    List<Course> selectCoursesByStudentsQuantity(int quantity);

    List<Course> selectCoursesByTheme(String theme);

    List<Course> selectCoursesByTeacher(int teacherId);
}
