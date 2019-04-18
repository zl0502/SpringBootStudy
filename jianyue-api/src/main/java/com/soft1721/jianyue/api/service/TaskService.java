package com.soft1721.jianyue.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
//@Async
public class TaskService {
    @Autowired
    private MailService mailService;

    @Scheduled(cron = "0 29 12 ? * *")
    public void proces(){
        mailService.sendMail("1459816730@qq.com","张丽","谢谢老师这个几周的辛苦付出，定时12.25发送");
        System.out.println("111");
    }
}
