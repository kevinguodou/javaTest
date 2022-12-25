package com.example.demo.jdk.proxy;

/**
 * @author dou.guo
 * @version DefaultOrderTicket, v 0.1 2022-08-09 11:40 上午 dou.guo Exp $
 */
public class DefaultOrderTicket implements OrderTicket{

    public void order(){
        System.out.println("成功订票一张");
    }

}
