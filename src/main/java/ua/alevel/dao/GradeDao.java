package ua.alevel.dao;

/**
 * DAO interface for db table grade
 *
 * @autor Victoria Aliaeva
 * @version 1.0
 * @since 2020-11-01
 */

import ua.alevel.dto.Grade;
import ua.alevel.dto.additional.GradeToBeAdded;
import ua.alevel.dto.additional.GradesInTeacherCourses;

import java.util.List;

public interface GradeDao {

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
     * @param teacherId id of teacher to search courses for
     * @return list of courses with grades
     */
    List<GradesInTeacherCourses> selectAllGradesByCourseTeacher(int teacherId);

    /**
     * Returns list of teacher course students from db that should be graded
     *
     * @param teacherId id of teacher to search students for
     * @return list of not graded students
     */
    List<GradeToBeAdded> selectNotGradedStudentsCourses(int teacherId);
}
