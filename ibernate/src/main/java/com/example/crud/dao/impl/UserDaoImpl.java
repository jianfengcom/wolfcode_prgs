package com.example.crud.dao.impl;

import com.example.crud.dao.IUserDao;
import com.example.crud.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Long userId) {

    }

    @Override
    public User get(Long userId) {
        // sessionFactory
        // session
        Configuration cfg = new Configuration().configure("/hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        User user = session.find(User.class, userId);

        session.close();
        factory.close();
        return user;
    }

    @Override
    public List<User> list() {
        return null;
    }
}
