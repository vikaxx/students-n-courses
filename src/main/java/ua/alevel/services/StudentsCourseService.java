package ua.alevel.services;

import ua.alevel.dto.StudentsCourse;

public interface StudentsCourseService {
     boolean addStudentToCourse(StudentsCourse studentsCourse, boolean isBanned);
}
