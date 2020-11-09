package ua.alevel.users;

/**
 * Class representing functions for teacher
 *
 * @autor Victoria Aliaeva
 * @version 1.0
 * @since 2020-11-01
 */

import ua.alevel.dto.Course;
import ua.alevel.dto.Grade;
import ua.alevel.dto.Teacher;
import ua.alevel.dto.additional.GradeToBeAdded;
import ua.alevel.dto.additional.GradesInTeacherCourses;

import java.util.List;

public interface TeacherUser {

    /**
     * Returns list of courses from db by specific teacher
     *
     * @return list of teacher's courses
     */
    List<Course> selectCoursesByTeacher();

    /**
     * Creates a new {@code Grade} in db
     *
     * @param newGrade parameters of new student's grade in {@code Grade} object
     * @return success of the operation
     */
    boolean addGrade(Grade newGrade);

    /**
     * Updates a {@code Grade} in db
     *
     * @param grade parameters of student's grade to update in {@code Grade} object
     * @return success of the operation
     */
    boolean updateGrade(Grade grade);

    /**
     * Returns list of teacher's courses from db with grades
     *
     * @return list of courses with grades
     */
    List<GradesInTeacherCourses> selectAllGradesByCourseTeacher();

    /**
     * Sets a number representing {@link Teacher#id} of {@code Teacher} in db
     * The value should be greater than 0
     *
     * @param teacherId id of teacher
     */
    void setTeacherId(int teacherId);


    /**
     * Returns list of teacher course students from db that should be graded
     *
     * @return list of not graded students
     */
    List<GradeToBeAdded> selectNotGradedStudentsCourses();

}
