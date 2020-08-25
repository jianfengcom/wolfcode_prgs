package com.example.crud.dao;

import com.example.crud.dao.impl.UserDaoImpl;
import com.example.crud.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IUserDaoTest {
    private IUserDao dao = new UserDaoImpl();

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void get() {
        User user = dao.get(1L);
        System.out.println(user);
    }

    @Test
    void list() {
    }
}