package com.zhou.boot.controller;

import com.zhou.boot.api.CommonResult;
import com.zhou.boot.domain.User;
import com.zhou.boot.service.UserService;
import com.zhou.boot.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    UserService userService;

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

    @PostMapping("/register")
    public CommonResult register(@RequestBody User user) {
        boolean userNameExist = userService.getUserIdByName(user.getUsername()) != null;

        if (userNameExist) {
            return CommonResult.validateFailed("用户已存在");
        } else {
            boolean success = userService.save(user);
            if (success) {
                return CommonResult.success("success");
            } else {
                return CommonResult.validateFailed("注册失败");
            }
        }
    }

    @PostMapping("/changPassword")
    public CommonResult changPassword(@RequestBody User user,
                                 @RequestParam(value = "newPassword", defaultValue = "") String newPassword) {
        boolean userExist = userService.isUserExist(user);

        System.out.println(user);
        System.out.println(newPassword);

        if (userExist) {
            user.setPassword(newPassword);
            userService.updateById(user);
            return CommonResult.success("修改成功");
        } else {
            return CommonResult.validateFailed("原密码错误");
        }
    }

}
