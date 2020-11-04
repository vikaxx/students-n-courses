package ua.alevel.services;

import ua.alevel.dto.Teacher;

import java.util.List;

public interface TeacherService {
    boolean addNewTeacher(Teacher newTeacher);
    List<Teacher> selectAllTeachers();
}
