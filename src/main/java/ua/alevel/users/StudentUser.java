package ua.alevel.users;

import ua.alevel.dto.Course;

import java.util.List;

public interface StudentUser {

    boolean addNewCourse(int courseId);

    List<Course> selectNotStartedCoursesByStudent();

    List<Course> selectStartedCoursesByStudent();

    List<Course> selectEndedCoursesByStudent();

}
