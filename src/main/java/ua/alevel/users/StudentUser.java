package ua.alevel.users;

/**
 * Class representing functions for student
 *
 * @autor Victoria Aliaeva
 * @version 1.0
 * @since 2020-11-01
 */

import ua.alevel.dto.Course;
import ua.alevel.dto.Student;

import java.util.List;

public interface StudentUser {

    /**
     * Creates a new {@code StudentsCourse} in db
     * Adds new student to the course and adds new course to the student
     *
     * @param courseId id of new student course
     * @return success of the operation
     */
    boolean goToNewCourse(int courseId);

    /**
     * Sets a number representing {@link Student#id} of {@code Student} in db
     * The value should be greater than 0
     *
     * @param studentId id of student
     */
    void setStudentId(int studentId);

    /**
     * Returns a student's ban status of {@code Student} from db
     * Value 'true' means student is blocked
     * Value 'false' means student is not blocked
     *
     * @return true or false
     */
    boolean isStudentBanned();

    /**
     * Returns list of student's courses from db that has not been started
     *
     * @return list of not started courses
     */
    List<Course> selectNotStartedCoursesByStudent();

    /**
     * Returns list of student's courses from db that has been started
     *
     * @return list of started courses
     */
    List<Course> selectStartedCoursesByStudent();

    /**
     * Returns list of student's courses from db that has been finished
     *
     * @return list of ended courses
     */
    List<Course> selectEndedCoursesByStudent();

    /**
     * Returns list of not student's courses from db that them can start
     *
     * @return list of not student's courses
     */
    List<Course> selectNotStartedCourses();

}
