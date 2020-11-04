package ua.alevel.users;

import ua.alevel.dto.Course;
import ua.alevel.dto.Teacher;

public interface AdminUser {

    boolean addNewTeacher(Teacher newTeacher);

    boolean addNewCourse(Course newCourse);

    boolean updateCourse(Course course);

    Course deleteCourse(int courseId);

    boolean putTeacherToCourse(int teacherId, int courseId);

    boolean setStudentBanned(int studentId, boolean banned);

}
