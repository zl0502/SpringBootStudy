
package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceImplTest {
    @Resource
    private MailService mailService;
    @Test
    public void sendMail() {
        mailService.sendMail("1459816730@qq.com","test","test");
    }
}
