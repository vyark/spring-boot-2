package com.epam.service;

import com.epam.model.User;

import java.util.List;

public interface UserService {

    // create operation
    User createUser(User user);

    // read operation
    List<User> readUser();

    // update operation
    User updateUser(User user, Long userId);

    // delete operation
    void deleteUserById(Long userId);
}
