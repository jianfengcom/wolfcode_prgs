package com.example.crud.dao.impl;

import com.example.crud.dao.IUserDao;
import com.example.crud.domain.User;
import com.example.crud.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

// sessionFactory
// session
public class UserDaoImpl implements IUserDao {
    @Override
    public void save(User user) {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction(); // 事务的打开方式, 还有一种
        session.save(user);
        tx.commit();
    }

    @Override
    public void update(User user) {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Long userId) {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();
        User user = new User(); user.setId(userId);
        session.delete(user);
        session.getTransaction().commit();
    }

    @Override
    public User get(Long userId) {
        Session session = HibernateUtils.openSession();
        User user = session.find(User.class, userId);

        /*session.close();
        factory.close();*/
        return user;
    }

    @Override
    public List<User> list() {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();
        List<User> users = session.createQuery("SELECT obj FROM User obj").list();
        session.getTransaction().commit();
        return users;
    }
}
