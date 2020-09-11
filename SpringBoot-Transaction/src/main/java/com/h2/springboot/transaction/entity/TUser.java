package com.h2.springboot.transaction.entity;

import com.h2.springboot.transaction.enu.SexEnum;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * 在用户类中使用mybatis别名
 */
@Data
@Alias(value = "tUser") //mybatis指定别名
public class TUser {

    private Long id;
    private String userName;
    //在mybatis体系中性别枚举,这里使用typeHandler进行转换,需要开发一个typeHandler继承BaseTypeHandler
    private SexEnum sex;
    private String note;
}
