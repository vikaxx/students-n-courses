package ua.alevel.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.alevel.dao.StudentsCourseDao;
import ua.alevel.dto.StudentsCourse;
import ua.alevel.services.StudentsCourseService;

@Service
public class StudentsCourseServiceImpl implements StudentsCourseService {
    @Autowired
    private StudentsCourseDao studentsCourseDao;

    @Override
    public boolean addStudentToCourse(StudentsCourse studentsCourse) {
        return studentsCourseDao.addStudentToCourse(studentsCourse);
    }
}
