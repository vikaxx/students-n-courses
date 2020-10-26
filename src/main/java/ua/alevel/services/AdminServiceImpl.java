package ua.alevel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.alevel.dao.AdminDao;
import ua.alevel.dto.Course;
import ua.alevel.dto.Table;
import ua.alevel.dto.Teacher;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public List<Table> selectAllRecordsInTable(String instanceName) {
        return adminDao.selectAllRecordsInTable(instanceName);
    }

    @Override
    public List<Course> selectAllCourses() {
        return adminDao.selectAllCourses();
    }

    @Override
    public List<Course> selectCoursesByTheme(String themeName) {
        return adminDao.selectCoursesByTheme(themeName);
    }

    @Override
    public boolean addNewTeacher(Teacher newTeacher) {
        return adminDao.addNewTeacher(newTeacher);
    }

    @Override
    public boolean putTeacherToCourse(int teacherId, int courseId) {
        return adminDao.putTeacherToCourse(teacherId, courseId);
    }

    @Override
    public boolean addNewCourse(Course newCourse) {
        return adminDao.addNewCourse(newCourse);
    }

    @Override
    public boolean updateCourse(Course course) {
        return adminDao.updateCourse(course);
    }

    @Override
    public Course deleteCourse(int courseId) {
        return adminDao.deleteCourse(courseId);
    }

    @Override
    public boolean setStudentBanned(int studentId, boolean banned) {
        return adminDao.setStudentBanned(studentId, banned);
    }

}
