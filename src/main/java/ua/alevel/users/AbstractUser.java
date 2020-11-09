package ua.alevel.users;

/**
 * Class representing functions for all types of users
 *
 * @autor Victoria Aliaeva
 * @version 1.0
 * @since 2020-11-01
 */

import ua.alevel.dto.Course;
import ua.alevel.dto.additional.CourseWithStudentsAmount;

import java.util.List;

public interface AbstractUser {

    /**
     * Returns list of all courses from db
     *
     * @return list of courses
     */
    List<Course> selectAllCourses();

    /**
     * Returns list of all courses from db, sorted alphabetically
     *
     * @return list of courses
     */
    List<Course> selectAllCoursesAZ();

    /**
     * Returns list of all courses from db, sorted alphabetically (reverse)
     *
     * @return list of courses
     */
    List<Course> selectAllCoursesZA();

    /**
     * Returns list of all courses from db, sorted by duration
     *
     * @param orderByDirection order of sorting - in order or in reverse order
     * @return list of courses
     */
    List<Course> selectCoursesSortedByDuration(String orderByDirection);

    /**
     * Returns list of all courses from db, sorted by students amount
     *
     * @param orderByDirection order of sorting - in order or in reverse order
     * @return list of courses with students amount
     */
    List<CourseWithStudentsAmount> selectCoursesSortedByStudentsQuantity(String orderByDirection);

    /**
     * Returns list of courses from db by specific theme
     *
     * @param theme theme of course
     * @return list of courses
     */
    List<Course> selectCoursesByTheme(String theme);

    /**
     * Returns list of courses from db by specific teacher
     *
     * @param teacherId id of teacher of course
     * @return list of courses
     */
    List<Course> selectCoursesByTeacher(int teacherId);
}
