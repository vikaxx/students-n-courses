package ua.alevel.services;

import ua.alevel.dto.Course;
import ua.alevel.dto.additional.CourseWithStudentsAmount;

import java.util.List;

public interface CourseService {
    List<Course> selectAllCourses();

    List<Course> selectAllCoursesAZ();

    List<Course> selectAllCoursesZA();

    List<Course> selectCoursesSortedByDuration(String orderByDirection);

    List<CourseWithStudentsAmount> selectCoursesSortedByStudentsQuantity(String orderByDirection);

    List<Course> selectCoursesByTheme(String theme);

    List<Course> selectCoursesByTeacher(int teacherId);

    boolean addNewCourse(Course newCourse);

    boolean updateCourse(Course course);

    Course deleteCourse(int courseId);

    boolean putTeacherToCourse(int teacherId, int courseId);

    List<Course> selectNotStartedCoursesByStudent(int studentId);

    List<Course> selectStartedCoursesByStudent(int studentId);

    List<Course> selectEndedCoursesByStudent(int studentId);

    List<Course> selectNotStartedCourses();

    List<Course> selectEndedCourses();
}
