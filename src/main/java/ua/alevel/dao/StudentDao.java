package ua.alevel.dao;

import ua.alevel.dto.Student;

import java.util.List;

public interface StudentDao {
    boolean setStudentBanned(int studentId, boolean banned);

    boolean isStudentBanned(int studentId);

    List<Student> selectAllStudents();

}
