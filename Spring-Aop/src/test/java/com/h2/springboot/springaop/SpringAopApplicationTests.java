package com.h2.springboot.springaop;

import com.h2.springboot.springaop.intercept.Interceptor;
import com.h2.springboot.springaop.intercept.MyInterceptor;
import com.h2.springboot.springaop.proxy.ProxyBean;
import com.h2.springboot.springaop.service.HelloService;
import com.h2.springboot.springaop.service.impl.HelloServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringAopApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testHelloServiceProxy() {
        HelloService helloService = new HelloServiceImpl();
        Interceptor interceptor = new MyInterceptor();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, interceptor);
        proxy.sayHello("jack");
       /* 返回结果
        before...
        around before...
        hello:jack
        around after
        after...
        afterReturning.*/

    }

    @Test
    public void testHelloServiceProxyException() {
        HelloService helloService = new HelloServiceImpl();
        Interceptor interceptor = new MyInterceptor();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, interceptor);
        proxy.sayHello(null);
       /* 异常结果
        before...
        around before...
        after...
        afterThrowing...*/
    }

}
