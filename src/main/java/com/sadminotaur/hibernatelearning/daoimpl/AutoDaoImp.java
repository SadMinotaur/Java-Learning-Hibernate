package com.sadminotaur.hibernatelearning.daoimpl;

import com.sadminotaur.hibernatelearning.dao.AutoDao;
import com.sadminotaur.hibernatelearning.model.Auto;
import com.sadminotaur.hibernatelearning.utils.HibernateSesFacUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

@Component
public class AutoDaoImp implements AutoDao {

    public AutoDaoImp() {
    }

    @Override
    public void addAuto(Auto auto) {
        Session session = HibernateSesFacUtil.getOpenedSession();
        Transaction transaction = session.beginTransaction();
        session.save(auto);
        transaction.commit();
        session.close();
    }

    @Override
    public Auto findAutoById(int id) {
        return HibernateSesFacUtil.getOpenedSession().get(Auto.class, id);
    }

    @Override
    public void update(Auto auto) {
        Session session = HibernateSesFacUtil.getOpenedSession();
        Transaction transaction = session.beginTransaction();
        session.update(auto);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Auto auto) {
        Session session = HibernateSesFacUtil.getOpenedSession();
        Transaction transaction = session.beginTransaction();
        session.delete(auto);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteAllAuto() {
        Session openedSession = HibernateSesFacUtil.getOpenedSession();
        Transaction transaction = openedSession.beginTransaction();
        openedSession.createQuery("delete from Auto").executeUpdate();
        transaction.commit();
        openedSession.close();
    }
}
