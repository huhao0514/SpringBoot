package com.h2.springboot.database.db;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by: huhao
 * Date: 2020/9/8
 * 监测数据库连接池类型
 */
@Component
//实现Spring Bean生命周期接口ApplicationContextAware
public class DataSourceShow implements ApplicationContextAware {
    ApplicationContext applicationContext=null;

    /*依照Spring Bean生命周期的规则,在其初始化的时候该方法就会被调用,
    * 从而获取Spring IOC容器的上下文(applicationContext),
    * 通过getBean的方法就可以获取数据库连接池.
    * */

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
        DataSource bean = applicationContext.getBean(DataSource.class);
        System.out.println("数据源类型为:"+bean.getClass().getName());

    }
}
