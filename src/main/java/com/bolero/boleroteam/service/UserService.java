package com.bolero.boleroteam.service;

import com.bolero.boleroteam.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(Long id);
    void save(User user);
    void remove(Long id);

    User findByUserName(String username);
    void changePassword(User user, String oldPassword, String newPassword);
}
