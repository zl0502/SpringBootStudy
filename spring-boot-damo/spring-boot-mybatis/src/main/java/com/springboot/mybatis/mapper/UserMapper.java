package com.springboot.mybatis.mapper;

import com.springboot.mybatis.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM t_sys_user ")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "password", column = "password"),
            @Result(property = "userName", column = "username"),
            @Result(property = "avatar", column = "avatar")

    })
    List<User> selectAll();

    @Select("SELECT * FROM t_sys_user WHERE user_id = #{userId}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "password", column = "password"),
            @Result(property = "userName", column = "username"),
            @Result(property = "avatar", column = "avatar"),

    })
    User getOne(Long userId);

   @Delete("DELETE FROM t_sys_user WHERE user_id =#{userId}")
    void delete(Long userId);

    @Insert("INSERT INTO t_sys_user(mobile,password,username,avatar) VALUES(#{mobile},#{password},#{userName},#{avatar})")
    void insert(User user);

    @Update("UPDATE t_sys_user SET avatar=#{avatar},username=#{userName} WHERE user_id=#{userId}")
    void update(User user);
}

