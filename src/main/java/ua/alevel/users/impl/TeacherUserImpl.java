package ua.alevel.users.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.alevel.dto.Course;
import ua.alevel.dto.Grade;
import ua.alevel.dto.additional.GradeToBeAdded;
import ua.alevel.dto.additional.GradesInTeacherCourses;
import ua.alevel.services.CourseService;
import ua.alevel.services.GradeService;
import ua.alevel.users.TeacherUser;

import java.util.List;

@Component
public class TeacherUserImpl implements TeacherUser {

    private int teacherId;

    @Override
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public List<Course> selectEndedCourses() {
        return courseService.selectEndedCourses();
    }

    @Override
    public List<GradeToBeAdded> selectNotGradedStudentsCourses(int teacherId) {
        if (teacherId > 0)
            return gradeService.selectNotGradedStudentsCourses(teacherId);
        else return null;
    }

    public TeacherUserImpl() {
    }

    public TeacherUserImpl(int teacherId) {
        this.teacherId = teacherId;
    }

    @Autowired
    private CourseService courseService;

    @Autowired
    private GradeService gradeService;

    @Override
    public List<Course> selectCoursesByTeacher() {
        if (teacherId > 0)
            return courseService.selectCoursesByTeacher(teacherId);
        else return null;
    }

    @Override
    public boolean addGrade(Grade grade) {
        if (grade != null) {
            if (grade.getMark() > -1 && grade.getMark() < 101)
                return gradeService.addGrade(grade);
        }
        return false;
    }

    @Override
    public boolean updateGrade(Grade newGrade) {
        if (newGrade != null) {
            if (newGrade.getMark() > -1 && newGrade.getMark() < 101)
                return gradeService.updateGrade(newGrade);
        }
        return false;
    }

    @Override
    public List<GradesInTeacherCourses> selectAllGradesByCourseTeacher() {
        if (teacherId > 0)
            return gradeService.selectAllGradesByCourseTeacher(teacherId);
        else return null;
    }
}
