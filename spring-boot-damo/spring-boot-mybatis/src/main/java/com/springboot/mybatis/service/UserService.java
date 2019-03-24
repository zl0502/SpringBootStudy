package com.springboot.mybatis.service;

import com.springboot.mybatis.entity.User;

import java.util.List;

public interface UserService {
    List<User> selectAll();
    User getOne(Long userId);

    void delete(Long userId);

    User insert(User user);

    void update(User user);
}
