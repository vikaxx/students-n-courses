package ua.alevel.users.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.alevel.dto.Course;
import ua.alevel.dto.Teacher;
import ua.alevel.services.CourseService;
import ua.alevel.services.StudentService;
import ua.alevel.services.TeacherService;
import ua.alevel.users.AdminUser;

@Component
public class AdminUserImpl extends AbstractUserImpl implements AdminUser {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @Override
    public boolean addNewTeacher(Teacher newTeacher) {
        if (newTeacher != null)
            if (newTeacher.getFirstName() != null && newTeacher.getLastName() != null)
                return teacherService.addNewTeacher(newTeacher);
        return false;
    }

    @Override
    public boolean addNewCourse(Course newCourse) {
        if (newCourse != null)
            if (newCourse.getName() != null && newCourse.getStartDate() != null)
                return courseService.addNewCourse(newCourse);
        return false;
    }

    @Override
    public boolean updateCourse(Course course) {
        if (course != null)
            if (course.getName() != null && course.getStartDate() != null)
                return courseService.updateCourse(course);
        return false;
    }

    @Override
    public Course deleteCourse(int courseId) {
        if (courseId > 0)
            return courseService.deleteCourse(courseId);
        else return null;
    }

    @Override
    public boolean putTeacherToCourse(int teacherId, int courseId) {
        if (teacherId > 0 && courseId > 0)
            return courseService.putTeacherToCourse(teacherId, courseId);
        else return false;
    }

    @Override
    public boolean setStudentBanned(int studentId, boolean banned) {
        if (studentId > 0)
            return studentService.setStudentBanned(studentId, banned);
        else return false;
    }
}
