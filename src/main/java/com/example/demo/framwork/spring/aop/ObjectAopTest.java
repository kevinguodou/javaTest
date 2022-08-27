package com.example.demo.framwork.spring.aop;

import java.lang.reflect.*;

/**
 * @author dou.guo
 * @version AopTest, v 0.1 2022-08-25 7:28 下午 dou.guo Exp $
 */
public class ObjectAopTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /*AopService aop2ServiceImpl =(AopService)getAopService(new Aop2Service());
        aop2ServiceImpl.work();*/

        /*AopService aop1ServiceImpl =(AopService)getAopService1(new Aop1Service());
        aop1ServiceImpl.work();*/

        AopService aop1ServiceImpl =(AopService)getAopService2(new Aop1Service());
        aop1ServiceImpl.work();
    }

    private static Object getAopService(Object target) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        //获取代理类class
        Class aopProxyClass = Proxy.getProxyClass(target.getClass().getClassLoader(),target.getClass().getInterfaces());

        //获取代理类class的构造器
        Constructor constructor = aopProxyClass.getConstructor(InvocationHandler.class);

        //通过构造器生成代理对象
        return constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //指定代理对象Aop1Service
                //Aop2Service aop1ServiceImpl = new Aop2Service();
                Object object = method.invoke(target,args);
                return object;
            }
        });
    }

    private static Object getAopService1(Object target) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Object object = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //指定代理对象Aop1Service
                        //Aop2Service aop1ServiceImpl = new Aop2Service();
                        Object result = method.invoke(target,args);
                        return result;
                    }
                });
        return object;
    }

    private static Object getAopService2(Object target) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        LogInvokeHandler logInvokeHandler = new LogInvokeHandler(target);
        Object object = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                logInvokeHandler);
        return object;
    }
}
