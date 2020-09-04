package com.h2.springboot.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by: huhao
 * Date: 2020/9/3
 */
@Data
@Component(value="user")
public class User {

    @Value("100") //指定具体的值,使得spring ioc给予对应的属性注入对应的值
    private String userId;
    @Value("测试用户")
    private String userName;
}
