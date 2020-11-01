package ua.alevel.services;

import ua.alevel.dto.Grade;
import ua.alevel.dto.additional.GradesInTeacherCourses;

import java.util.List;

public interface GradeService {

    boolean addGrade(Grade grade);

    boolean updateGrade(Grade newGrade);

    List<GradesInTeacherCourses> selectAllGradesByCourseTeacher(int teacherId);
}
