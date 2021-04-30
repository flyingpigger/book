package com.zhou.boot.service;

import com.zhou.boot.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface UserService extends IService<User> {

    boolean isUserExist(User user);

    Integer getUserIdByName(String username);

}
