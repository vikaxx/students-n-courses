package ua.alevel.dao;

import ua.alevel.dto.Theme;

import java.util.List;

public interface ThemeDao {
    List<Theme> selectAllThemes();
}
