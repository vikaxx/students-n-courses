package ua.alevel.users;

import ua.alevel.dto.Course;

import java.util.List;

public interface StudentUser {

    boolean goToNewCourse(int courseId);

    void setStudentId(int studentId);

    boolean isStudentBanned(int studentId);

    List<Course> selectNotStartedCoursesByStudent();

    List<Course> selectStartedCoursesByStudent();

    List<Course> selectEndedCoursesByStudent();

    List<Course> selectNotStartedCourses();

}
