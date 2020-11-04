package ua.alevel.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.alevel.dao.StudentDao;
import ua.alevel.dao.StudentsCourseDao;
import ua.alevel.dto.StudentsCourse;
import ua.alevel.services.StudentsCourseService;

@Service
public class StudentsCourseServiceImpl implements StudentsCourseService {
    @Autowired
    private StudentsCourseDao studentsCourseDao;

    @Autowired
    private StudentDao studentDao;

    @Override
    public boolean addStudentToCourse(StudentsCourse studentsCourse) {
        if (studentsCourse != null) {
            boolean isBanned = studentDao.isStudentBanned(studentsCourse.getStudentId());
            if (!isBanned)
                return studentsCourseDao.addStudentToCourse(studentsCourse);
        }
        return false;
    }
}
