package com.sadminotaur.hibernatelearning.dao;

import com.sadminotaur.hibernatelearning.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BasicMethods {

    @Autowired
    private UserDao userDao;

    private final User userOne = new User("test", "test", "test", 1);

    @BeforeEach
    public void clean() {
        userDao.deleteAllUsers();
    }

    @Test
    public void testAddingUser() {
        userDao.addUser(userOne);
        assertEquals(userOne, userDao.findById(userOne.getId()));
    }

    @Test
    public void testUpdate() {
        userDao.addUser(userOne);
        userOne.setAge(10);
        userDao.update(userOne);
        assertEquals(userOne, userDao.findById(userOne.getId()));
    }

    @Test
    public void testUserDelete() {
        userDao.addUser(userOne);
        userDao.delete(userOne);
        assertNull(userDao.findById(userOne.getId()));
    }
}