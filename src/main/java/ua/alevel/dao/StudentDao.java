package ua.alevel.dao;

import ua.alevel.dto.Course;

import java.util.List;

public interface StudentDao {
    boolean goToCourse(int courseId);

    List<Course> selectNotStartedCourses();

    List<Course> selectStartedCourses();

    List<Course> selectEndedCourses();
}
