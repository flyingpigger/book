package com.zhou.boot.controller;

import com.zhou.boot.api.CommonResult;
import com.zhou.boot.domain.CartInfo;
import com.zhou.boot.domain.User;
import com.zhou.boot.service.AddressService;
import com.zhou.boot.service.CartService;
import com.zhou.boot.service.UserService;
import com.zhou.boot.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    AddressService addressService;

    @PostMapping("/login")
    public CommonResult login(@RequestBody User user, HttpServletResponse response) {
        boolean userExist = userService.isUserExist(user);
        if (userExist) {
            String userName = user.getUsername();
            Integer uid = userService.getUserIdByName(userName);
            CookieUtils.writeCookie(response, "uid", uid.toString());
            CookieUtils.writeCookie(response, "userName", userName);
            return CommonResult.success("success");
        } else
            return CommonResult.validateFailed("failed");
    }

}
