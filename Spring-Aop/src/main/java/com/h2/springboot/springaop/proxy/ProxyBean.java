package com.h2.springboot.springaop.proxy;

import com.h2.springboot.springaop.intercept.Interceptor;
import com.h2.springboot.springaop.intercept.Invocation;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * Created by: huhao
 * Date: 2020/9/5
 * 这个类实现将服务类和拦截方法织入对应的流程中
 * 约定编程: 当调用proxy对象的方法时,执行流程
 * 1:执行拦截器的before方法
 * 2:如果拦截器的useAround返回true,执行拦截器的around方法,而不调用target对象对应的方法,
 * 但around方法的参数invocation对象存在一个proceed方法,会调用target对象对应的方法,
 * 如果useAround返回false,则直接调用target原有方法
 * 3:无论怎样,都执行after方法
 * 4:在执行around方法,或者回调target的事件方法发生异常走执行afterThrowing方法,否则走afterReturning.
 *
 */
public class ProxyBean implements InvocationHandler {

    private Object target = null;

    private Interceptor interceptor = null;

    /**
     * 绑定被代理对象,返回代理对象,使用jdk中的
     *
     * @param target      被代理对象
     * @param interceptor 拦截器接口
     * @return 代理对象
     */
    public static Object getProxyBean(Object target, Interceptor interceptor) {
        ProxyBean proxyBean = new ProxyBean();
        //保存被代理对象
        proxyBean.target = target;
        //保存拦截器
        proxyBean.interceptor = interceptor;
        //生成代理对象
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxyBean);
        return proxy;
    }

    /**
     * 重写InvocationHandler的invoke方法,处理代理对象方法逻辑
     *
     * @param proxy  代理对象
     * @param method 当前方法
     * @param args   运行参数
     * @return 方法调用结果
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //异常标识
        boolean exceptionFlag = false;
        Invocation invocation = new Invocation(target, method, args);
        this.interceptor.before();
        Object retObj = null;
        try {
            if(this.interceptor.userAround()){ //执行拦截器around方法
                retObj=this.interceptor.around(invocation);
            }else{ //走原始方法
                retObj=method.invoke(target,args);
            }

        } catch (Exception e) { //走around方法或者调用target原始方法发生异常
            exceptionFlag=true;
        }
        this.interceptor.after();//无论怎么样,都会执行after方法
        if(exceptionFlag){
            this.interceptor.afterThrowing();//发生异常走afterThrowing
        }else{
            this.interceptor.afterReturning();
            return retObj;
        }
        return null;
    }
}
