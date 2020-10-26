package ua.alevel.dao;

import ua.alevel.dto.Course;

import java.util.List;

public interface TeacherDao {
    List<Course> selectAllTeacherCourses();

    boolean addGrade(int studentId);
}
