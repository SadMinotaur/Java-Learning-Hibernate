package com.sadminotaur.hibernatelearning.dao;

import com.sadminotaur.hibernatelearning.model.User;
import com.sadminotaur.hibernatelearning.utils.HibernateSesFacUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BasicMethods {

    @Autowired
    private UserDao userDao;

    @BeforeEach
    public void clean() {
        Session openedSession = HibernateSesFacUtil.getOpenedSession();
        Transaction transaction = openedSession.beginTransaction();
        openedSession.createQuery("delete from UserBase").executeUpdate();
        transaction.commit();
        openedSession.close();
    }

    @Test
    public void testAddingUser() {
        userDao.save(new User("test", "test", "test", 1));
    }

}
