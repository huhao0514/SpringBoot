package com.h2.springboot.transaction.mapper;

import com.h2.springboot.transaction.entity.TUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TUserMapper {

    TUser getUser(long id);

    int insertUser(TUser tUser);
    
}
