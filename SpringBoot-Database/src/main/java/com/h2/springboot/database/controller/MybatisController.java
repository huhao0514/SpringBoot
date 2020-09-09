package com.h2.springboot.database.controller;

import com.h2.springboot.database.mapper.TUserMapper;
import com.h2.springboot.database.entity.TUser;
import com.h2.springboot.database.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisController {

    @Autowired
    private TUserService tUserService;

    @GetMapping("getUserMybatis")
    public TUser getUserById(@RequestParam long id) {
        return tUserService.getUser(id);
    }
}
