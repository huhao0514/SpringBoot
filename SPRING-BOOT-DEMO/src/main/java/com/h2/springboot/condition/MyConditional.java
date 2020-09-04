package com.h2.springboot.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by: huhao
 * Date: 2020/9/4
 */
public class MyConditional implements Condition {
    /**
     * @param conditionContext      条件上下文
     * @param annotatedTypeMetadata 注释类型的元数据
     * @return true:装配bean,false:不装配bean
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //获取上下文环境
        Environment env = conditionContext.getEnvironment();
        return env.containsProperty("mycondition.id")
                && env.containsProperty("mycondition.name");
    }
}
