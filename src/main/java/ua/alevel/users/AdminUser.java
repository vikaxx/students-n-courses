package ua.alevel.users;

/**
 * Class representing functions for admin
 *
 * @autor Victoria Aliaeva
 * @version 1.0
 * @since 2020-11-01
 */

import ua.alevel.dto.Course;
import ua.alevel.dto.Teacher;

public interface AdminUser {

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
     * Creates a new {@code Teacher} in db
     *
     * @param newTeacher parameters of new teacher in {@code Teacher} object
     * @return success of the operation
     */
    boolean addNewTeacher(Teacher newTeacher);

    /**
     * Updates a student's ban status of {@code Student} in db
     *
     * @param studentId id of student
     * @param banned    new status
     * @return success of the operation
     */
    boolean setStudentBanned(int studentId, boolean banned);

}
