package com.h2.springboot.config;

import com.alibaba.fastjson.JSONObject;
import com.h2.springboot.DemoApplication;
import com.h2.springboot.pojo.User;
import com.h2.springboot.pojo.Worker;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

/**
 * Created by: huhao
 * Date: 2020/9/3
 */
@SpringBootTest(classes = {DemoApplication.class})
@Slf4j
@RunWith(SpringRunner.class)
public class AppConfigTest {

    @Test
    public void userConfig() {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = (User) context.getBean("user");
        log.info(JSONObject.toJSONString(user));

    }

    @Test
    public void animalConfig() {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Worker worker = (Worker) context.getBean("worker");
        worker.work();
    }

    @Test
    public void testDataSource() {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        log.info(dataSource.toString());
    }
}