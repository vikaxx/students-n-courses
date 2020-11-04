package ua.alevel.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.alevel.dao.TeacherDao;
import ua.alevel.dto.Teacher;
import ua.alevel.services.TeacherService;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public boolean addNewTeacher(Teacher newTeacher) {
        if (newTeacher != null)
            if (newTeacher.getFirstName() != null && newTeacher.getLastName() != null)
                return teacherDao.addNewTeacher(newTeacher);
        return false;
    }

    @Override
    public List<Teacher> selectAllTeachers() {
        return teacherDao.selectAllTeachers();
    }
}
