package com.h2.springboot.transaction.service;


import com.h2.springboot.transaction.entity.TUser;

public interface TUserService {
    TUser getUser(long id);

    int insertUser(TUser tUser);
}
