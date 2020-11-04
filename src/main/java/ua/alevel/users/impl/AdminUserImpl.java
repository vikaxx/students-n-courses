package ua.alevel.users.impl;

import ua.alevel.dto.Course;
import ua.alevel.dto.Teacher;
import ua.alevel.users.AdminUser;

public class AdminUserImpl extends AbstractUserImpl implements AdminUser{

    @Override
    public boolean addNewTeacher(Teacher newTeacher) {
        return false;
    }

    @Override
    public boolean addNewCourse(Course newCourse) {
        return false;
    }

    @Override
    public boolean updateCourse(Course course) {
        return false;
    }

    @Override
    public Course deleteCourse(int courseId) {
        return null;
    }

    @Override
    public boolean putTeacherToCourse(int teacherId, int courseId) {
        return false;
    }

    @Override
    public boolean setStudentBanned(int studentId, boolean banned) {
        return false;
    }
}
