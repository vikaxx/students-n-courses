package ua.alevel.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.alevel.dao.TeacherDao;
import ua.alevel.dto.Teacher;
import ua.alevel.services.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public boolean addNewTeacher(Teacher newTeacher) {
        return teacherDao.addNewTeacher(newTeacher);
    }
}
