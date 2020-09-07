package com.h2.springboot.springaop.aspect.service.impl;

import com.h2.springboot.springaop.aspect.service.IUserService;
import com.h2.springboot.springaop.pojo.User;
import org.springframework.stereotype.Service;

/**
 * Created by: huhao
 * Date: 2020/9/7
 * 动态代理实现方式,当你需要使用aop的类拥有接口时,Spring会以jdk的动态代理运行,否则以CGLIB
 */
@Service
public class UserService2   {

    public void printUser(User user) {
        if(null == user){
            throw  new RuntimeException("user is null");
        }
        System.out.println("id:"+user.getId());
    }
}
