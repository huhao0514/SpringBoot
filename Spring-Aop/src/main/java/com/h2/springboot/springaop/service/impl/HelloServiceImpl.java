package com.h2.springboot.springaop.service.impl;

import com.h2.springboot.springaop.service.HelloService;
import org.aopalliance.intercept.Interceptor;

/**
 * Created by: huhao
 * Date: 2020/9/5
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        if(null == name || name.trim()==""){
            throw  new RuntimeException("name is empty");
        }
        System.out.println("hello:"+name);
    }
}
