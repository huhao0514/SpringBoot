package com.h2.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.h2.springboot.pojo.MyCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    private MyCondition myCondition;

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


    @GetMapping("condition")
    public String getCondition() {

        if (myCondition != null) {
            return JSONObject.toJSONString(myCondition);
        }else{
            return null;
        }
    }
}
