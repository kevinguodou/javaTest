package com.example.demo.framwork.spring.aop;

/**
 * @author dou.guo
 * @version Aop1Service, v 0.1 2022-08-25 7:30 下午 dou.guo Exp $
 */
public class Aop1Service implements AopService{

    @Override
    public void work(){
        System.out.println("Aop1Service");
    }
}
