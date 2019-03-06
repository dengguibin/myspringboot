package com.lshjy.crud.service;


import com.lshjy.crud.model.User;

import java.util.List;

/**
 * The interface User service.
 *
 * @author Liaozihong
 */
public interface UserService {
    /**
     * Gets user list.
     *
     * @return the user list
     */
    List<User> getUserList();

    /**
     * Find user by id user.
     *
     * @param id the id
     * @return the user
     */
    User findUserById(Integer id);

    /**
     * Save.
     *
     * @param user the user
     */
    void save(User user);

    /**
     * Edit.
     *
     * @param user the user
     */
    void edit(User user);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(Integer id);
}
