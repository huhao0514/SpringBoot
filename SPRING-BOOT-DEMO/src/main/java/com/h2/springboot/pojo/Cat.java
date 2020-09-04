package com.h2.springboot.pojo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by: huhao
 * Date: 2020/9/3
 */
@Slf4j
@Component(value = "cat") //表明这个类将被spring ioc容器扫描装配.
public class Cat implements  Animal{
    @Override
    public void eat() {
        log.info("======猫吃猫粮=====");
    }
}
