package com.h2.springboot.springaop.controller;

import com.h2.springboot.springaop.aspect.service.IUserService;
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

    @GetMapping(value = "print")
    public User printUser(@RequestParam String id,@RequestParam String name){
           User user=new User()
                   .setId(id)
                   .setName(name);
        userService.printUser(user);
        return user;
    }
}
