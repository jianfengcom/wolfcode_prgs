package com.example.crud.dao;

import com.example.crud.domain.User;

import java.util.List;

public interface IUserDao {
    void save(User user);
    void update(User user);
    void delete(Long userId);
    User get(Long userId);
    List<User> list();
}
