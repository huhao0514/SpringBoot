package com.h2.springboot.springaop.aspect.validator.impl;

import com.h2.springboot.springaop.aspect.validator.IUserValidator;
import com.h2.springboot.springaop.pojo.User;

/**
 * IUserValidator的实现类
 */
public class UserValidatorImpl implements IUserValidator {
    @Override
    public boolean validate(User user) {
        System.out.println("引入新的接口:" + IUserValidator.class.getSimpleName());
        return user != null;
    }
}
