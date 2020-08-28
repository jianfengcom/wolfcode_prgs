package com.example.crud.dao.impl;

import com.example.crud.dao.IUserDao;
import com.example.crud.domain.User;
import com.example.crud.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
        session.close();
    }

    @Override
    public void update(User user) {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long userId) {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();
        User user = new User(); user.setId(userId);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User get(Long userId) {
        Session session = HibernateUtils.openSession();
        // session.find(User.class, userId); // find & get
        User user = session.get(User.class, userId);

        session.close(); // session对象是线程不安全的 (connection 亦然)
        // factory.close(); sessionFactory对象是线程安全的
        return user;
    }

    @Override
    public List<User> list() {
        Session session = HibernateUtils.openSession();
        String hql = "SELECT obj FROM User obj";
        Query query = session.createQuery(hql); //创建查询对象
        List<User> users = query.list();
        session.close();
        return users;
    }
}
