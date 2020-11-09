package ua.alevel.dao;

/**
 * DAO interface for db table user
 *
 * @autor Victoria Aliaeva
 * @version 1.0
 * @since 2020-11-01
 */

import ua.alevel.dto.User;

public interface UserDao {

    /**
     * Returns {@code Student} from db with specific login
     *
     * @return user
     */
    User selectUserByLogin(String login);
}
