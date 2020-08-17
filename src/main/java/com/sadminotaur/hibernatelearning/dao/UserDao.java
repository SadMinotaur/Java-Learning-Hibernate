package com.sadminotaur.hibernatelearning.dao;

import com.sadminotaur.hibernatelearning.model.Auto;
import com.sadminotaur.hibernatelearning.model.User;

import java.util.List;

public interface UserDao {

    User findById(int id);

    void save(User user);

    void update(User user);

    void delete(User user);

    Auto findAutoById(int id);
}
