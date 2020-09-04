package com.h2.springboot.pojo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by: huhao
 * Date: 2020/9/3
 */
@Slf4j
@Component(value = "worker")
public class Worker implements Person {

    /**
     * 当按类型注入(DI)bean时,匹配到了多个bean,解决方法:
     * 1:配合@Qualifier指定bean的名称进行注入(建议使用)
     * 2:将注入的属性名称改为要注入的bean的name,这样显然不合编码语义及灵活性,不建议使用
     * 3:在Bean的java类中使用@Primary注解,匹配到多个bean时,默认选带@Primary注解的.
     */
    @Autowired
    @Qualifier(value = "cat")
    private Animal animal;
    @Override
    public void work() {
        log.info("工人喂养"+animal.getClass().getSimpleName());
        animal.eat();
    }
}
