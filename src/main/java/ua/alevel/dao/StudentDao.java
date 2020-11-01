package ua.alevel.dao;

public interface StudentDao {
    boolean setStudentBanned(int studentId, boolean banned);

    boolean isStudentBanned(int studentId);
}
