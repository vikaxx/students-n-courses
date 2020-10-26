package ua.alevel.dto;

import java.sql.ResultSet;

public interface Table {
    Table mapResultSetToTableObject(ResultSet resultSet);
}
