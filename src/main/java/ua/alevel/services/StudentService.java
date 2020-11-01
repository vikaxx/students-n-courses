package ua.alevel.services;

public interface StudentService {
    boolean setStudentBanned(int studentId, boolean banned);

    boolean isStudentBanned(int studentId);
}
