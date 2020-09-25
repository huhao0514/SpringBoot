package com.h2.springboot.transaction.controller;

import com.h2.springboot.transaction.entity.TUser;
import com.h2.springboot.transaction.service.IUserBatchService;
import com.h2.springboot.transaction.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MybatisController {

    @Autowired
    private TUserService tUserService;

    @Autowired
    private IUserBatchService userBatchService;

    @GetMapping("getUserMybatis")
    public TUser getUserById(@RequestParam long id) {
        return tUserService.getUser(id);
    }

    @GetMapping("insertUser")
    public int getUserById(@RequestParam(name="id1") long id1,@RequestParam(name="id2") long id2) {
        List<TUser> list=new ArrayList<>();
        TUser user1=new TUser();
        user1.setId(id1);
        user1.setUserName(id1+"");
        TUser user2=new TUser();
        user2.setId(id2);
        user2.setUserName(id2+"");
        list.add(user1);
        list.add(user2);
        int i = userBatchService.inserUser(list);
        return i;
    }

}
