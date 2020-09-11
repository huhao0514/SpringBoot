package com.h2.springboot.transaction.service.impl;

import com.h2.springboot.transaction.entity.TUser;
import com.h2.springboot.transaction.mapper.TUserMapper;
import com.h2.springboot.transaction.service.TUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TUserServiceImpl implements TUserService {

    @Resource
    private TUserMapper tUserMapper;
    @Override
    public TUser getUser(long id) {
        return tUserMapper.getUser(id);
    }


    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.NESTED)
    @Override
    public int insertUser(TUser tUser) {
        return tUserMapper.insertUser(tUser);
    }
}
