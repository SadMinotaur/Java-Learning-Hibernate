package com.sadminotaur.hibernatelearning.dao;

import com.sadminotaur.hibernatelearning.model.Auto;
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
    @Autowired
    private AutoDao autoDao;

    private final User userOne = new User("test", "test", "test", 1);
    private final Auto autoOne = new Auto("test", "test");

    @BeforeEach
    public void clean() {
        userDao.deleteAllUsers();
        autoDao.deleteAllAutos();
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

    @Test
    public void testAddAuto() {
        autoDao.addAuto(autoOne);
        assertEquals(autoOne, autoDao.findAutoById(autoOne.getId()));
    }

    @Test
    public void testUpdateAuto() {
        autoDao.addAuto(autoOne);
        autoOne.setColor("sad");
        autoDao.update(autoOne);
        assertEquals(autoOne, autoDao.findAutoById(autoOne.getId()));
    }

    @Test
    public void testDeleteAuto() {
        autoDao.addAuto(autoOne);
        autoDao.delete(autoOne);
        assertNull(autoDao.findAutoById(userOne.getId()));
    }

    @Test
    public void testSetAuto() {
        userDao.addUser(userOne);
        autoOne.setUser(userOne);
        autoDao.addAuto(autoOne);
        assertEquals(userOne, autoDao.findAutoById(autoOne.getId()).getUser());
    }
}