package com.mirko.library.service;

import com.mirko.library.model.User;

import java.util.List;

public interface UserService {

    /**
     * This option will return all users from database
     * @return all users
     */
    List<User> findAllUsers();

    /**
     * This option will return single user by matching ID
     * @param id by this id user will be found
     * @return user by matching id
     */
    User findByID(Long id);

    /**
     * This oprion will delete user by matchig ID
     * @param id - id of the user to be deleted
     */
    void delete(Long id);

    /**
     * This option saves user
     * @param newUser new user to be saved
     * @return returns user that has been saved
     */
    User saveUser(User newUser);

    /**
     * This option returns a user found by username provided
     * @param userName searching parameter
     * @return user with given username
     */
    User findByUserName(String userName);
}
