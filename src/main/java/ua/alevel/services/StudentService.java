package ua.alevel.services;

import ua.alevel.dto.Student;

import java.util.List;

public interface StudentService {
    boolean setStudentBanned(int studentId, boolean banned);

    boolean isStudentBanned(int studentId);

    List<Student> selectAllStudents();

}
