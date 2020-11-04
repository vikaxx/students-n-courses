package ua.alevel.dao;

import ua.alevel.dto.Teacher;

import java.util.List;

public interface TeacherDao {
    boolean addNewTeacher(Teacher newTeacher);

    List<Teacher> selectAllTeachers();

}
