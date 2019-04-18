package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.service.MailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class MailServiceImpl implements MailService {
    @Resource
    private JavaMailSender mailSender;
    @Override
    public void sendMail(String to, String subject, String content) {
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("1459816730@qq.com");//发起者
        mailMessage.setTo("1459816730@qq.com");//接受者
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        try {
            mailSender.send(mailMessage);
            System.out.println("发送邮件成功");
        }catch (Exception e){
            System.out.println("发送邮件失败");
        }
    }

}
