package com.h2.springboot.transaction.service;


import com.h2.springboot.transaction.entity.TUser;

import java.util.List;

/**
 * Created by: huhao
 * Date: 2020/9/11
 */
public interface IUserBatchService {

    int inserUser(List<TUser> tUsers);
}
