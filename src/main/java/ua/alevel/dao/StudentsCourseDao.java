package ua.alevel.dao;

/**
 * DAO interface for db table studentCourse
 *
 * @autor Victoria Aliaeva
 * @version 1.0
 * @since 2020-11-01
 */

import ua.alevel.dto.StudentsCourse;

public interface StudentsCourseDao {

    /**
     * Creates a new {@code StudentsCourse} in db
     * Adds new student to the course and adds new course to the student
     *
     * @param studentsCourse parameters of new student course in {@code StudentsCourse} object
     * @return success of the operation
     */
    boolean addStudentToCourse(StudentsCourse studentsCourse);
}
