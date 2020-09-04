package com.h2.springboot.config;

import com.h2.springboot.properties.DataBaseProperties;
import lombok.Data;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by: huhao
 * Date: 2020/9/3
 */
@Configuration//代表这是一个java配置文件,spring容器会根据它来生成ioc容器装配bean
@ComponentScan(basePackages = {"com.h2.springboot.*"})
public class AppConfig {
    /**
     * 1:config中所需要的属性最好封装成对应的properties对象,将需要的属性交给properties对象来维护.
     * 2:注入对应配置的properties的bean
     */
/*
    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;


    @Value("${spring.datasource.password}")
    private String password;*/

    @Autowired
    private DataBaseProperties dataBaseProperties;

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DataSource dataSource = null;
        Properties properties = new Properties();
        properties.setProperty("driver", dataBaseProperties.getDriver());
        properties.setProperty("url", dataBaseProperties.getUrl());
        properties.setProperty("username", dataBaseProperties.getName());
        properties.setProperty("password", dataBaseProperties.getPassword());

        try {
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

}
