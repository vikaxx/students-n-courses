package ua.alevel.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.alevel.dao.GradeDao;
import ua.alevel.datasource.DataSource;
import ua.alevel.dto.Grade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class GradeDaoImpl implements GradeDao {
    private static final Logger LOG = LoggerFactory.getLogger(TableDaoImpl.class);
    private DataSource dataSource;

    @Autowired // достать поле из конструктора который предоставляет спринг
    public GradeDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public GradeDaoImpl() {
    }

    @Override
    public boolean addGrade(Grade grade) {
        try (final Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO " +
                     "grade (mark, studentsCourseId) VALUES(?, ?)")) {

            ps.setInt(1, grade.getMark());
            ps.setInt(2, grade.getStudentsCourseId());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOG.error("SQL Error", e);
        }
        return false;
    }
}
