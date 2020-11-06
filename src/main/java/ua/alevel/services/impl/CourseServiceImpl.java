package ua.alevel.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.alevel.dao.CourseDao;
import ua.alevel.dto.Course;
import ua.alevel.dto.additional.CourseWithStudentsAmount;
import ua.alevel.services.CourseService;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> selectAllCourses() {
        return courseDao.selectAllCourses();
    }

    @Override
    public List<Course> selectAllCoursesAZ() {
        return courseDao.selectAllCoursesAZ();
    }

    @Override
    public List<Course> selectAllCoursesZA() {
        return courseDao.selectAllCoursesZA();
    }

    @Override
    public List<Course> selectCoursesSortedByDuration(String orderByDirection) {
        if (orderByDirection != null) {
            orderByDirection = orderByDirection.toUpperCase();
            if (orderByDirection.equals("ASC") || orderByDirection.equals("DESC"))
                return courseDao.selectCoursesSortedByDuration(orderByDirection);
        }
        return null;
    }

    @Override
    public List<CourseWithStudentsAmount> selectCoursesSortedByStudentsQuantity(String orderByDirection) {
        if (orderByDirection != null) {
            orderByDirection = orderByDirection.toUpperCase();
            if (orderByDirection.equals("ASC") || orderByDirection.equals("DESC"))
                return courseDao.selectCoursesSortedByStudentsQuantity(orderByDirection);
        }
        return null;
    }

    @Override
    public List<Course> selectCoursesByTheme(String theme) {
        if (theme != null)
            if (!theme.isEmpty())
                return courseDao.selectCoursesByTheme(theme);
        return null;
    }

    @Override
    public List<Course> selectCoursesByTeacher(int teacherId) {
        if (teacherId > 0)
            return courseDao.selectCoursesByTeacher(teacherId);
        else return null;
    }

    @Override
    public boolean addNewCourse(Course newCourse) {
        if (newCourse != null)
            if (newCourse.getName() != null && newCourse.getStartDate() != null)
                return courseDao.addNewCourse(newCourse);
        return false;
    }

    @Override
    public boolean updateCourse(Course course) {
        if (course != null)
            if (course.getName() != null && course.getStartDate() != null)
                return courseDao.updateCourse(course);
        return false;
    }

    @Override
    public Course deleteCourse(int courseId) {
        if (courseId > 0)
            return courseDao.deleteCourse(courseId);
        else return null;
    }

    @Override
    public boolean putTeacherToCourse(int teacherId, int courseId) {
        if (teacherId > 0 && courseId > 0)
            return courseDao.putTeacherToCourse(teacherId, courseId);
        else return false;
    }

    @Override
    public List<Course> selectNotStartedCoursesByStudent(int studentId) {
        if (studentId > 0)
            return courseDao.selectNotStartedCoursesByStudent(studentId);
        else return null;
    }

    @Override
    public List<Course> selectStartedCoursesByStudent(int studentId) {
        if (studentId > 0)
            return courseDao.selectStartedCoursesByStudent(studentId);
        else return null;
    }

    @Override
    public List<Course> selectEndedCoursesByStudent(int studentId) {
        if (studentId > 0)
            return courseDao.selectEndedCoursesByStudent(studentId);
        else return null;
    }

    @Override
    public List<Course> selectNotStartedCourses() {
        return courseDao.selectNotStartedCourses();
    }

    @Override
    public List<Course> selectEndedCourses() {
        return courseDao.selectEndedCourses();
    }
}
