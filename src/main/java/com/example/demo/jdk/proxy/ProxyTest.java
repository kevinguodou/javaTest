package com.example.demo.jdk.proxy;

import java.lang.reflect.Method;

/**
 * @author dou.guo
 * @version ProxyTest, v 0.1 2022-08-09 11:41 上午 dou.guo Exp $
 */
public class ProxyTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        OrderTicket orderTicket = new OrderTicketProxy();
        Class<?> aClass = Class.forName("com.example.demo.jdk.proxy.OrderTicket");
        Method[] methods = aClass.getMethods();
        OrderTicket orderTicket1 = (OrderTicket) aClass.newInstance();
        orderTicket.order();
    }
}
