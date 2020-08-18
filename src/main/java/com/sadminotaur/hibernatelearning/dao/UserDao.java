package com.sadminotaur.hibernatelearning.dao;

import com.sadminotaur.hibernatelearning.model.User;

public interface UserDao {

    User findById(int id);

    void addUser(User user);

    void update(User user);

    void delete(User user);

    void deleteAllUsers();
}
