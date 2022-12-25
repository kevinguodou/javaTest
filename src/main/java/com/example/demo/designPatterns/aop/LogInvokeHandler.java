package com.example.demo.designPatterns.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author dou.guo
 * @version LogInvokeHandler, v 0.1 2022-08-25 9:46 下午 dou.guo Exp $
 */
public class LogInvokeHandler implements InvocationHandler {

    public Object target;

    LogInvokeHandler(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始调用方法");
        Object result = method.invoke(target,args);
        System.out.println("调用方法结束");
        return result;
    }

}
