package com.h2.springboot.springaop.aspect.validator;

import com.h2.springboot.springaop.pojo.User;

/**
 * 用户检测接口
 */
public interface IUserValidator {

    /**
     * 检测用户对象是否为空
     * @param user
     * @return
     */
    public boolean validate(User user);
}
