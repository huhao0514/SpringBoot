package com.h2.springboot.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by: huhao
 * Date: 2020/9/4
 * 1:ConfigurationProperties中prefix属性值是唯一的,不能重复.
 *
 */
@Component(value = "dataBaseProperties")
@ConfigurationProperties("spring.datasource") //需要引入属性文件依赖,根据prefix+属性名,自动拼接为属性文件key全称
@Data
public class DataBaseProperties {

    @Value("${spring.datasource.driver-class-name}")
    private String driver;
    private String url;
    private String name;
    private String password;
}
