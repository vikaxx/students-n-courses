package ua.alevel.users.impl;

import ua.alevel.dto.Course;
import ua.alevel.dto.Grade;
import ua.alevel.dto.additional.GradesInTeacherCourses;
import ua.alevel.users.TeacherUser;

import java.util.List;

public class TeacherUserImpl extends AbstractUserImpl implements TeacherUser {
    @Override
    public List<Course> selectCoursesByTeacher() {
        return null;
    }

    @Override
    public boolean addGrade(Grade grade) {
        return false;
    }

    @Override
    public boolean updateGrade(Grade newGrade) {
        return false;
    }

    @Override
    public List<GradesInTeacherCourses> selectAllGradesByCourseTeacher() {
        return null;
    }
}
