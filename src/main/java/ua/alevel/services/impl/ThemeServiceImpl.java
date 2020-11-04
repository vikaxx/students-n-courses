package ua.alevel.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.alevel.dao.ThemeDao;
import ua.alevel.dto.Theme;
import ua.alevel.services.ThemeService;

import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService {

    @Autowired
    private ThemeDao themeDao;

    @Override
    public List<Theme> selectAllThemes() {
        return themeDao.selectAllThemes();
    }
}
