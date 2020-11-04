package ua.alevel.users;

import ua.alevel.dto.Course;
import ua.alevel.dto.Grade;
import ua.alevel.dto.additional.GradesInTeacherCourses;

import java.util.List;

public interface TeacherUser {

    List<Course> selectCoursesByTeacher();

    boolean addGrade(Grade grade);

    boolean updateGrade(Grade newGrade);

    List<GradesInTeacherCourses> selectAllGradesByCourseTeacher();
}