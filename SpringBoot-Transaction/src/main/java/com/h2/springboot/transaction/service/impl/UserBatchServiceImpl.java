package com.h2.springboot.transaction.service.impl;

import com.h2.springboot.transaction.entity.TUser;
import com.h2.springboot.transaction.service.IUserBatchService;
import com.h2.springboot.transaction.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by: huhao
 * Date: 2020/9/11
 */
@Service
public class UserBatchServiceImpl implements IUserBatchService {

    @Autowired
    private TUserService tUserService;

    /**
     * @Transactional加入事务,isolation设置数据库隔离级别,propagation:设置事务传播
     * @param tUsers
     * @return
     * 1:UserBatchServiceImpl调用tUserService方法,若子方法没设置事务传播策略,则沿用当前事务策略.发生异常都回滚
     * 2:设置子方法的传播策略为NESTED,
     */
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    @Override
    public int inserUser(List<TUser> tUsers) {
        int count=0;
        if(CollectionUtils.isEmpty(tUsers)){
            return count;
        }
        for (TUser tUser : tUsers) {
            count+=tUserService.insertUser(tUser);
        }
        return count;
    }
}
