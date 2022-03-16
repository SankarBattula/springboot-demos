package io.sb.demosecurity.service;


import io.sb.demosecurity.entity.User;

import java.util.List;

public interface UserService {

    /**
     * Get all the users in db.
     * @return
     */
    List<User> getAllUsers();
}
