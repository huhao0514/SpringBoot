package com.h2.springboot.config;

import com.h2.springboot.condition.MyConditional;
import com.h2.springboot.pojo.MyCondition;
import com.h2.springboot.properties.DataBaseProperties;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 条件装配bean配置文件
 * Created by: huhao
 * Date: 2020/9/3
 * 解决properties文件中文乱码:
 * 1:指定encoding为utf-8
 * 2:settings->editor->file encodings中设置为utf-8,并勾选Transparent native-to-ascii conversion
 */
@Configuration//代表这是一个java配置文件,spring容器会根据它来生成ioc容器装配bean
@ComponentScan(basePackages = {"com.h2.springboot.*"})
@PropertySource(value = {"classpath:mycondition.properties"},encoding = "UTF-8")
public class ConditionConfig {

    @Bean(name = "myCondition")//加上Bean后,方法中的参数必须要注入属性对应的值
    @Conditional(MyConditional.class)
    public MyCondition getMyCondition(@Value("${mycondition.id}") String id,
                                      @Value("${mycondition.name}") String name) {
        MyCondition condition = new MyCondition();
        condition.setId(id);
        condition.setName(name);
        return condition;
    }

}
