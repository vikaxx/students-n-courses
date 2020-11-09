package ua.alevel.dao;

/**
 * DAO interface for db table student
 *
 * @autor Victoria Aliaeva
 * @version 1.0
 * @since 2020-11-01
 */

import ua.alevel.dto.Student;

import java.util.List;

public interface StudentDao {

    /**
     * Updates a student's ban status of {@code Student} in db
     *
     * @param studentId id of student
     * @param banned    new status
     * @return success of the operation
     */
    boolean setStudentBanned(int studentId, boolean banned);

    /**
     * Returns a student's ban status of {@code Student} from db
     * Value 'true' means student is blocked
     * Value 'false' means student is not blocked
     *
     * @param studentId id of student
     * @return true or false
     */
    boolean isStudentBanned(int studentId);

    /**
     * Returns list of all students from db
     *
     * @return list of students
     */
    List<Student> selectAllStudents();

}
