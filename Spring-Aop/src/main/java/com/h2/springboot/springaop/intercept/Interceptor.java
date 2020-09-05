package com.h2.springboot.springaop.intercept;


import java.lang.reflect.InvocationTargetException;

/**
 * Created by: huhao
 * Date: 2020/9/5
 * 定义拦截器接口
 */
public interface Interceptor {

    /**
     * 事前方法
     *
     * @return
     */
    public boolean before();

    /**
     * 事后方法
     */
    public void after();

    /**
     * 取代原有事件方法
     * @param invocation 回调参数,通过调用proceed方法以反射形式去调用原有事件
     * @return 原调事件返回对象
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public Object around(Invocation invocation) throws Throwable;

    /**
     * 事后返回方法,事件没有发生异常时执行
     */
    public void afterReturning();

    /**
     * 事后异常方法,当事件发生异常后执行.
     */
    public void afterThrowing();

    /**
     * 是否使用around方法取代原有方法
     * @return
     */
    public boolean userAround();
}
