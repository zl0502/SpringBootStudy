package com.springboot.mybatis.service.impl;

import com.springboot.mybatis.entity.Course;
import com.springboot.mybatis.entity.User;
import com.springboot.mybatis.service.UserService;
import com.springboot.mybatis.util.RandomUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Resource
    private UserService userService;

    @Test
    public void selectAll() {
        List<User> userList=userService.selectAll();
        userList.forEach(user -> System.out.println(user));
    }

    @Test
    public void getOne() {
        User user = userService.getOne(1L);
        System.out.println(user);

    }

    @Test
    public void delete() {
        userService.delete(5L);
    }

    @Test
    public void insert() {
        User user = new User();
        user.setMobile("18463257485");
        user.setPassword("999");
        user.setUserName("时间");
        user.setAvatar("9.jpg");

        userService.insert(user);
    }

    @Test
    public void update() {
        User user=userService.getOne(21L);
        user.setMobile("111111111");
        user.setPassword("9999");
        userService.update(user);
    }
}
