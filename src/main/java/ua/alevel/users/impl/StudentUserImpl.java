package ua.alevel.users.impl;

import ua.alevel.dto.Course;
import ua.alevel.users.StudentUser;

import java.util.List;

public class StudentUserImpl extends AbstractUserImpl implements StudentUser {
    @Override
    public boolean addNewCourse(int courseId) {
        return false;
    }

    @Override
    public List<Course> selectNotStartedCoursesByStudent() {
        return null;
    }

    @Override
    public List<Course> selectStartedCoursesByStudent() {
        return null;
    }

    @Override
    public List<Course> selectEndedCoursesByStudent() {
        return null;
    }
}
