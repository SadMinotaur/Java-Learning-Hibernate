package com.sadminotaur.hibernatelearning.utils;

import com.sadminotaur.hibernatelearning.model.Auto;
import com.sadminotaur.hibernatelearning.model.User;
import com.sadminotaur.hibernatelearning.model.UserBase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateSesFacUtil {

    private static SessionFactory sessionFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateSesFacUtil.class);

    private HibernateSesFacUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(UserBase.class);
                configuration.addAnnotatedClass(Auto.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                LOGGER.info(e.toString());
            }
        }
        return sessionFactory;
    }

    public static Session getOpenedSession() {
        SessionFactory sessionFactory = getSessionFactory();
        return sessionFactory.openSession();
    }
}


