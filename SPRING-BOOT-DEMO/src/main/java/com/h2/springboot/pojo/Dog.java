package com.h2.springboot.pojo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Created by: huhao
 * Date: 2020/9/3
 */
@Slf4j
@Component
//@Primary
public class Dog  implements  Animal{
    @Override
    public void eat() {
        log.info("======狗吃狗粮=====");
    }
}
