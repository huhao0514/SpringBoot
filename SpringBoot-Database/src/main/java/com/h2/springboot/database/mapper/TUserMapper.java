package com.h2.springboot.database.mapper;

import com.h2.springboot.database.entity.TUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TUserMapper {

    TUser getUser(long id);
    
}
