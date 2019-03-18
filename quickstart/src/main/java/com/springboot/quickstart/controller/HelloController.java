package com.springboot.quickstart.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//springboot的第一个请求
@RestController
class HelloController {
    @RequestMapping(value="/hello",method=RequestMethod.GET)
    public String getHello(){
        return "Hello,Spring boot...";

    }
}
