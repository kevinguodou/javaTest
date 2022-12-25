package com.example.demo.designPatterns.aop;

import java.lang.reflect.Proxy;

/**
 * @author dou.guo
 * @version SimpleAopTest, v 0.1 2022-08-25 9:57 下午 dou.guo Exp $
 */
public class SimpleAopTest {
    public static void main(String[] args) {
        Aop1Service target = new Aop1Service();

        //具体执行的处理器
        LogInvokeHandler logInvokeHandler = new LogInvokeHandler(target);

        //获取target（Aop1Service）的代理实体
        AopService proxy = (AopService)Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),logInvokeHandler);
        proxy.work();
    }
}
