package com.h2.springboot.springaop.aspect.service.impl;

import com.h2.springboot.springaop.aspect.service.IUserService;
import com.h2.springboot.springaop.pojo.User;
import org.springframework.stereotype.Service;

/**
 * Created by: huhao
 * Date: 2020/9/7
 */
@Service
public class UserServiceImpl implements IUserService {
    @Override
    public void printUser(User user) {
        if(null == user){
            throw  new RuntimeException("user is null");
        }
        System.out.println("id:"+user.getId());
    }
}
