package com.h2.springboot.database.service;

import com.h2.springboot.database.entity.TUser;

public interface TUserService {
    TUser getUser(long id);
}
