package ua.alevel.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.alevel.dao.GradeDao;
import ua.alevel.dto.Grade;
import ua.alevel.dto.additional.GradesInTeacherCourses;
import ua.alevel.services.GradeService;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeDao gradeDao;

    @Override
    public boolean addGrade(Grade grade) {
        if (grade.getMark() > -1 && grade.getMark() < 101)
            return gradeDao.addGrade(grade);
        else return false;
    }

    @Override
    public boolean updateGrade(Grade newGrade) {
        if (newGrade.getMark() > -1 && newGrade.getMark() < 101)
            return gradeDao.updateGrade(newGrade);
        else return false;
    }

    @Override
    public List<GradesInTeacherCourses> selectAllGradesByCourseTeacher(int teacherId) {
        if (teacherId > 0)
            return gradeDao.selectAllGradesByCourseTeacher(teacherId);
        else return null;
    }
}
