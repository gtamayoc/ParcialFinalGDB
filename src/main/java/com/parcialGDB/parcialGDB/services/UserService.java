package com.parcialGDB.parcialGDB.services;

import com.parcialGDB.parcialGDB.models.User;

import java.util.List;

public interface UserService {
    User findByEmail(String email);
    List<User> getAllUsers();
    User createUser(User user);
    User updateUser(String id, User user);
    void deleteUser(String id);
}