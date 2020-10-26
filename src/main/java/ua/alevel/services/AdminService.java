package ua.alevel.services;

import ua.alevel.dto.Course;
import ua.alevel.dto.Table;
import ua.alevel.dto.Teacher;

import java.util.List;

public interface AdminService {
    List<Course> selectAllCourses();

    List<Table> selectAllRecordsInTable(String tableName);

    List<Course> selectCoursesByTheme(String themeName);

    boolean addNewTeacher(Teacher newTeacher);

    boolean putTeacherToCourse(int teacherId, int courseId);

    boolean addNewCourse(Course newCourse);

    boolean updateCourse(Course course);

    Course deleteCourse(int courseId);

    boolean setStudentBanned(int studentId, boolean banned);

}
