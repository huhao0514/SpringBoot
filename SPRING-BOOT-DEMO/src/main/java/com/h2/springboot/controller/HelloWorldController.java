package com.h2.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * Created by: huhao
 * Date: 2020/9/4
 */
@RestController
public class HelloWorldController {

    @Autowired
    private DataSource dataSource;

    /**
     * 测试是否能获取到数据源
     * @return
     */
    @GetMapping("dataSource")
    public String getDataSource() {

        if (dataSource != null) {
            return dataSource.toString();
        }else{
            return null;
        }
    }

}
