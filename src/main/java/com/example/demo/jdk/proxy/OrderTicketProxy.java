package com.example.demo.jdk.proxy;

/**
 * @author dou.guo
 * @version OrderTicketProxy, v 0.1 2022-08-09 11:44 上午 dou.guo Exp $
 */
public class OrderTicketProxy implements OrderTicket{

    private DefaultOrderTicket defaultOrderTicket;

    public OrderTicketProxy(){
        super();
        this.defaultOrderTicket = new DefaultOrderTicket();
    }

    @Override
    public void order() {
        System.out.println("代理任务执行中");
        defaultOrderTicket.order();
        System.out.println("代理任务结束");
    }

}
