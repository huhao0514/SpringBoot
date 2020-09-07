package com.h2.springboot.springaop.aspect;

import com.h2.springboot.springaop.aspect.validator.IUserValidator;
import com.h2.springboot.springaop.aspect.validator.impl.UserValidatorImpl;
import com.h2.springboot.springaop.pojo.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by: huhao
 * Date: 2020/9/7
 * 1:Spring是以@Aspect作为切面声明,当以@Aspect作为注解时,Spring就会知道这是一个切面,
 * 然后我们可以通过各类的注解来定义各类的通知.
 * 2:@Pointcut,定义切点,向spring描述哪些类哪些方法需要启用AOP编程.
 */
@Aspect
@Component
public class UserAspect {


    /**
     *  引入新的用户校验接口
     *   @DeclareParents 引入新的类来增强服务
     *   属性:value 指向你要增强功能的目标对象
     *        defaultImpl 引入增强功能的类
     */
    @DeclareParents(value = "com.h2.springboot.springaop.aspect.service.impl.UserServiceImpl+"
            ,defaultImpl = UserValidatorImpl.class)
    public IUserValidator userValidator;

    /**
     * 使用@Pointcut来定义切点,标注在方法pointcut上
     * 后面的通知注解中可以使用方法名称来定义了.
     * execution(* com.h2.springboot.springaop.aspect.service.impl.UserServiceImpl.printUser(..))分析:
     * 1:execution表示在执行的时候,拦截器里面的正则匹配的方法.
     * 2:*表示任意的返回类型
     * 3:com.h2.springboot.springaop.aspect.service.impl.UserServiceImpl表示目标对象的全限定名称
     * 4:printUser表示指定目标对象的指定方法
     * 5:(..)表示任意参数进行匹配.
     */
    @Pointcut(value = "execution(* com.h2.springboot.springaop.aspect.service.impl.UserServiceImpl.printUser(..))")
    public void pointcut(){ }

    /**
     * 通知获取参数
     * @param joinPoint
     * @param user
     * 正则式:pointcut() && args(user),pointcut()表示启用原来定义切点的规则,
     * 并且约定将连接点(目标对象方法)名称user的参数传递进来.
     * JoinPoint类型的参数对于非环绕型通知而言,环绕型通知用ProceedingJoinPoint
     *
     */
    @Before("pointcut() && args(user)")
    public void beforeParam(JoinPoint joinPoint, User user){
        Object[] args = joinPoint.getArgs();
        Arrays.asList(args).stream().forEach(System.out::println);
    }

    @Before("pointcut()")
    public void before(){
        System.out.println("before...");
    }

    @After("pointcut()")
    public void after(){
        System.out.println("after...");
    }

    /**
     * 环绕通知是一个取代原有目标对象方法的通知,也提供了回调原有目标对象方法的能力.
     * @param joinPoint
     * @throws Throwable
     */
    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("arouond before...");
        joinPoint.proceed(); //回调目标对象的原有方法
        System.out.println("around after...");


    }

    @AfterReturning("pointcut()")
    public void afterReturning(){
        System.out.println("afterReturning...");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing(){
        System.out.println("afterThrowing...");
    }
}
