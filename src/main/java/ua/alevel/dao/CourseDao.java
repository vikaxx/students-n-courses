package ua.alevel.dao;

/**
 * DAO interface for db table course
 *
 * @autor Victoria Aliaeva
 * @version 1.0
 * @since 2020-11-01
 */

import ua.alevel.dto.Course;
import ua.alevel.dto.additional.CourseWithStudentsAmount;

import java.util.List;

public interface CourseDao {

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

    /**
     * Creates a new {@code Course} in db
     *
     * @param newCourse parameters of new course in {@code Course} object
     * @return success of the operation
     */
    boolean addNewCourse(Course newCourse);

    /**
     * Updates a {@code Course} in db
     *
     * @param course parameters of course to update in {@code Course} object
     * @return success of the operation
     */
    boolean updateCourse(Course course);

    /**
     * Delete a {@code Course} from db
     *
     * @param courseId id of course to delete
     * @return deleted course in {@code Course} object
     */
    Course deleteCourse(int courseId);

    /**
     * Updates a teacher of {@code Course} in db
     *
     * @param teacherId id of new teacher of the course
     * @param courseId  id of course to update a teacher
     * @return success of the operation
     */
    boolean putTeacherToCourse(int teacherId, int courseId);

    /**
     * Returns list of student's courses from db that has not been started
     *
     * @param studentId id of student to search courses for
     * @return list of not started courses
     */
    List<Course> selectNotStartedCoursesByStudent(int studentId);

    /**
     * Returns list of student's courses from db that has been started
     *
     * @param studentId id of student to search courses for
     * @return list of started courses
     */
    List<Course> selectStartedCoursesByStudent(int studentId);

    /**
     * Returns list of student's courses from db that has been finished
     *
     * @param studentId id of student to search courses for
     * @return list of ended courses
     */
    List<Course> selectEndedCoursesByStudent(int studentId);

    /**
     * Returns list of not student's courses from db that them can start
     *
     * @param exceptStudentId id of student to search courses for
     * @return list of not student's courses
     */
    List<Course> selectNotStartedCourses(int exceptStudentId);

    /**
     * Returns list of courses from db that has been finished
     *
     * @return list of ended courses
     */
    List<Course> selectEndedCourses();
}
