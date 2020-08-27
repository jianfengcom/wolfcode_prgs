package com.example.crud.dao;

import com.example.crud.dao.impl.UserDaoImpl;
import com.example.crud.domain.User;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IUserDaoTest {
    private IUserDao dao = new UserDaoImpl();

    @Test
    void save() {
        // User user = new User(null, "任天堂", new BigDecimal(2100), new Date());
        User user = dao.get(1L);
        dao.save(user);
    }

    @Test
    void update() {
        User user = new User(2L, "索尼", new BigDecimal(2100), new Date());
        dao.update(user);
    }

    @Test
    void delete() {
        dao.delete(3L);
    }

    @Test
    void get() {
        User user = dao.get(1L);
        System.out.println(user);
    }

    @Test
    void list() {
        List<User> users = dao.list();
        System.out.println(users);
    }
}