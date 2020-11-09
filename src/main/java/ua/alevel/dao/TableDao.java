package ua.alevel.dao;

/**
 * Abstract DAO interface for db table
 *
 * @autor Victoria Aliaeva
 * @version 1.0
 * @since 2020-11-01
 */

import ua.alevel.dto.Table;

import java.util.List;

public interface TableDao {

    /**
     * Returns list of all records in specific table from db
     * <T> means class of table object
     *
     * @return list of records
     */
    <T extends Table> List<T> selectAllRecordsInTable(String tableName);
}
