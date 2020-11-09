package ua.alevel.dao;

/**
 * DAO interface for db table teacher
 *
 * @autor Victoria Aliaeva
 * @version 1.0
 * @since 2020-11-01
 */

import ua.alevel.dto.Teacher;

import java.util.List;

public interface TeacherDao {

    /**
     * Creates a new {@code Teacher} in db
     *
     * @param newTeacher parameters of new teacher in {@code Teacher} object
     * @return success of the operation
     */
    boolean addNewTeacher(Teacher newTeacher);

    /**
     * Returns list of all teachers from db
     *
     * @return list of teachers
     */
    List<Teacher> selectAllTeachers();

}
