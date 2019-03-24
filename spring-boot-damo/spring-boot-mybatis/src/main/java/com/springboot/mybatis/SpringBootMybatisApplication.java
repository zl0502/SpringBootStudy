package com.springboot.mybatis;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSwagger2Doc
@MapperScan("com.springboot.mybatis.mapper")
public class SpringBootMybatisApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootMybatisApplication.class, args);
    }

}
