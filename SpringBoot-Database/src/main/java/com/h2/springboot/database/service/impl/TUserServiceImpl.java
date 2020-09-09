package com.h2.springboot.database.service.impl;

import com.h2.springboot.database.entity.TUser;
import com.h2.springboot.database.mapper.TUserMapper;
import com.h2.springboot.database.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TUserServiceImpl implements TUserService {

    @Resource
    private TUserMapper tUserMapper;
    @Override
    public TUser getUser(long id) {
        return tUserMapper.getUser(id);
    }
}
