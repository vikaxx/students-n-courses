package ua.alevel.users.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.alevel.dto.Course;
import ua.alevel.dto.StudentsCourse;
import ua.alevel.services.CourseService;
import ua.alevel.services.StudentService;
import ua.alevel.services.StudentsCourseService;
import ua.alevel.users.StudentUser;

import java.util.List;

@Component
public class StudentUserImpl implements StudentUser {

    private int studentId;

    public int getStudentId() {
        return studentId;
    }

    @Override
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean isStudentBanned(int studentId) {
        return studentService.isStudentBanned(studentId);
    }

    public StudentUserImpl() {
    }

    public StudentUserImpl(int studentId) {
        this.studentId = studentId;
    }

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentsCourseService studentsCourseService;

    @Autowired
    private CourseService courseService;


    @Override
    public boolean goToNewCourse(int courseId) {
        if (courseId > 0) {
            boolean isBanned = studentService.isStudentBanned(this.studentId);
            if (!isBanned) {
                StudentsCourse studentsCourse = new StudentsCourse();
                studentsCourse.setCourseId(courseId);
                studentsCourse.setStudentId(this.studentId);
                return studentsCourseService.addStudentToCourse(studentsCourse);
            }
        }
        return false;
    }

    @Override
    public List<Course> selectNotStartedCoursesByStudent() {
        if (studentId > 0)
            return courseService.selectNotStartedCoursesByStudent(studentId);
        else return null;
    }

    @Override
    public List<Course> selectStartedCoursesByStudent() {
        if (studentId > 0)
            return courseService.selectStartedCoursesByStudent(studentId);
        else return null;
    }

    @Override
    public List<Course> selectEndedCoursesByStudent() {
        if (studentId > 0)
            return courseService.selectEndedCoursesByStudent(studentId);
        else return null;
    }

    @Override
    public List<Course> selectNotStartedCourses(int exceptStudentId) {
        return courseService.selectNotStartedCourses(exceptStudentId);
    }
}
