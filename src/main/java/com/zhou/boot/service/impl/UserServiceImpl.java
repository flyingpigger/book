package com.zhou.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.boot.domain.User;
import com.zhou.boot.service.UserService;
import com.zhou.boot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean isUserExist(User user) {
        if (userMapper.userCount(user) == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer getUserIdByName(String username) {
        return userMapper.getUserIdByName(username);
    }
}




