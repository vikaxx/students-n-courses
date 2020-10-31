package ua.alevel.dao;

import ua.alevel.dto.Course;

import java.util.List;

public interface StudentDao {
    boolean setStudentBanned(int studentId, boolean banned);
}
