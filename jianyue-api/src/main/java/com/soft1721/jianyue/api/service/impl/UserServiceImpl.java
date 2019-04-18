package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.User;
import com.soft1721.jianyue.api.entity.dto.UserDTO;
import com.soft1721.jianyue.api.mapper.UserMapper;
import com.soft1721.jianyue.api.service.UserService;
import com.soft1721.jianyue.api.util.StatusConst;
import com.soft1721.jianyue.api.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByMobile(String mobile) {

        return userMapper.getUserByMobile(mobile);
    }

    @Override
    public int signIn(UserDTO userDTO) {
        User user = userMapper.getUserByMobile(userDTO.getMobile());
        //手机号存在
        if (user != null) {
            //密码正确
            if (userDTO.getPassword().equals(user.getPassword())) {
                //账号正常
                if (user.getStatus() == 1) {
                    user.setToken(StringUtil.getUUIDString());
                    userMapper.update(user);
                    return StatusConst.SUCCESS;
                } else {  //账号异常
                    return StatusConst.USER_STATUS_ERROR;
                }
            } else {  //密码错误
                return StatusConst.PASSWORD_ERROR;
            }
        } else {  //手机号不存在
            return StatusConst.USER_MOBILE_NOT_FOUND;
        }
    }

    @Override
    public User getUserById(int userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public void updateUser(User user) {
        userMapper.update(user);

    }

    @Override
    public int signUp(UserDTO userDTO) {
        //先根据手机号找用户是否存在
        User user = userMapper.getUserByMobile(userDTO.getMobile());
        if (user != null) {
            return StatusConst.MOBILE_EXIST;
        } else {
            User user1 = new User();
            user1.setMobile(userDTO.getMobile());
            user1.setPassword(StringUtil.getBase64Encoder(userDTO.getPassword()));
            user1.setNickname("新用户");
            user1.setAvatar("http://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/default.png?Expires=1554292133&OSSAccessKeyId=TMP.AQHz8QArrtzxbb3VQMkjjdlwB2JvoOvmIMBh4CoHPerk718LdNehNeLBWDEcMC4CFQDgleDgj6q_VsjSB-9lTP7KcdjU1gIVAOnRS2ovGQSHNf9WpHc4nSLw0-OH&Signature=NT9%2BSOt7FX4VvmQnvt7B8XvKtmA%3D");
            user1.setRegtime(new Date());
            user1.setStatus((short) 1);
            userMapper.insert(user1);
            return StatusConst.SUCCESS;
        }
    }

    @Override
    public void nickname(User user) {
        userMapper.nickname(user);
    }
    }

