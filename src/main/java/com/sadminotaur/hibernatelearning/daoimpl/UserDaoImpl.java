package com.sadminotaur.hibernatelearning.daoimpl;

import com.sadminotaur.hibernatelearning.dao.UserDao;
import com.sadminotaur.hibernatelearning.model.Auto;
import com.sadminotaur.hibernatelearning.model.User;
import com.sadminotaur.hibernatelearning.utils.HibernateSesFacUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
    }

    public User findById(int id) {
        return HibernateSesFacUtil.getOpenedSession().get(User.class, id);
    }

    public void save(User user) {
        Session session = HibernateSesFacUtil.getOpenedSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSesFacUtil.getOpenedSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = HibernateSesFacUtil.getOpenedSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public Auto findAutoById(int id) {
        return HibernateSesFacUtil.getOpenedSession().get(Auto.class, id);
    }
}