package com.example.demo.framwork.spring.aop;

import java.lang.reflect.*;

/**
 * @author dou.guo
 * @version AopTest, v 0.1 2022-08-25 7:28 下午 dou.guo Exp $
 */
public class AopTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        AopService aopServiceImpl = getAopService(new Aop2Service());
        aopServiceImpl.work();
    }

    private static AopService getAopService(AopService aopService) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        //获取代理类class
        Class aopServiceProxyClass = Proxy.getProxyClass(AopService.class.getClassLoader(),AopService.class);

        //获取代理类class的构造器
        Constructor constructor = aopServiceProxyClass.getConstructor(InvocationHandler.class);

        //通过构造器生成代理对象
        return (AopService)constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //指定代理对象Aop1Service
                //Aop2Service aop1ServiceImpl = new Aop2Service();
                Object object = method.invoke(aopService,args);
                return object;
            }
        });
    }
}
