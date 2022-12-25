package com.example.demo.jdk.proxy.dynamic;

import java.lang.reflect.*;

/**
 * @author dou.guo
 * @version MapperProxy, v 0.1 2022-09-29 11:39 上午 dou.guo Exp $
 */
public class MapperProxy {

    /**
     * 获取代理类
     * @param clzz
     */
     public static  <T>  T getMapper(Class<T> clzz)  {
         try {
             //生成代理类class,让代理类实现相同接口
             Class<?> proxyClass = Proxy.getProxyClass(clzz.getClassLoader(), clzz.getInterfaces());

             //InvocationHandler就是一个接口，只提供了invoke方法
             //获取构造器：Proxy没有无参构造器，只有一个传递InvocationHandler.class参数的构造函数方法！
             Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
             return (T) constructor.newInstance(new InvocationHandler() {
                 @Override
                 public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                     System.out.println("代理中");
                     //代理类会生成被代理类的所有方法，并且在这些方法里都会调用InvocationHandler.invoke,其中proxy传的就是被代理对象的实例，method为对应的方法
                     Object invoke = method.invoke(proxy, args);
                     return invoke;
                 }
             });
         }catch (Exception e){
             return null;
         }
    }

}
