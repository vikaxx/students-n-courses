package ua.alevel.dao;

/**
 * DAO interface for db table theme
 *
 * @autor Victoria Aliaeva
 * @version 1.0
 * @since 2020-11-01
 */

import ua.alevel.dto.Theme;

import java.util.List;

public interface ThemeDao {

    /**
     * Returns list of all themes from db
     *
     * @return list of themes
     */
    List<Theme> selectAllThemes();
}
