package ua.alevel.dao;

import ua.alevel.dto.Table;

import java.util.List;

public interface TableDao {
    <T extends Table> List<T> selectAllRecordsInTable(String tableName);
}
