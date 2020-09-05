package com.h2.springboot.springaop.intercept;

import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by: huhao
 * Date: 2020/9/5
 * 调用类,调用proceed方法以反射的形式调用原有方法
 */
@Data
public class Invocation {
    private Object target;
    private Method method;
    private Object[] params;

    public Invocation(Object target, Method method, Object[] params) {
        this.target = target;
        this.method = method;
        this.params = params;
    }

    /**
     * 反射调用原有方法
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public Object proceed() throws InvocationTargetException, IllegalAccessException {

        return method.invoke(target,params);

    }
}
