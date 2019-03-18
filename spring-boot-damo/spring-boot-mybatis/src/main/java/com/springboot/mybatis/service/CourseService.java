package com.springboot.mybatis.service;

import com.springboot.mybatis.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> selectAll();
    Course getOne(Long courseId);

    void delete(long courseId);

    Course insert(Course course);

    void update(Course course);
}
