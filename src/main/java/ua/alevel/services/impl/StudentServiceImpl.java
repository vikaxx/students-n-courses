package ua.alevel.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.alevel.dao.StudentDao;
import ua.alevel.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public boolean setStudentBanned(int studentId, boolean banned) {
        if (studentId > 0)
            return studentDao.setStudentBanned(studentId, banned);
        else return false;
    }

    @Override
    public boolean isStudentBanned(int studentId) {
        return studentDao.isStudentBanned(studentId);
    }
}
