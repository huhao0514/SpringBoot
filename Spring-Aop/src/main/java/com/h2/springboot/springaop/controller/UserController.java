package com.h2.springboot.springaop.controller;

import com.h2.springboot.springaop.aspect.service.IUserService;
import com.h2.springboot.springaop.aspect.service.impl.UserService2;
import com.h2.springboot.springaop.aspect.validator.IUserValidator;
import com.h2.springboot.springaop.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by: huhao
 * Date: 2020/9/7
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserService2 userService2;

    @GetMapping(value = "print")
    public User printUser(@RequestParam String id, @RequestParam String name) {
        User user = new User()
                .setId(id)
                .setName(name);
        //验证user为null情况.
        //User user=null;
        //强制转换
        IUserValidator userValidator = (IUserValidator) userService;
        //验证用户是否为空
        if (userValidator.validate(user)) {
            userService.printUser(user);
        }
        return user;
    }

    @GetMapping(value = "print2")
    public User printUser2(@RequestParam String id, @RequestParam String name) {
        User user = new User()
                .setId(id)
                .setName(name);
       userService2.printUser(user);
        return user;
    }
}
